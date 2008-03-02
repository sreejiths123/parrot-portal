package com.parrot.maven.xpatch;

/*
 * Copyright 2001-2005 The Apache Software Foundation. Licensed under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See
 * the License for the specific language governing permissions and limitations under the License.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.transform.TransformerException;

import com.parrot.maven.utils.StringHelper;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * XPatch goal for cocoon configuration files.
 * 
 * @goal xpatch
 * @phase process-sources
 * @since 2.1.9
 * @requiresDependencyResolution compile
 */
public class XPatchMojo extends AbstractMojo {
    
    private static final String FSEP = System.getProperty("file.separator");
    private static final String NL = System.getProperty("line.separator");
    
    /**
     * Whether to add a comment indicating where this block of code comes from.
     * 
     * @parameter default-value="false"
     */
    private boolean addComments;
    
    /**
     * The Avalon config location. Is considered as a jar file path, without the root slash.
     * 
     * @parameter default-value="META-INF/cocoon/avalon"
     */
    private String avalonConfigDirectory;
    
    private Pattern avalonConfigPattern;
    
    private DocumentCache documentCache;
    
    private boolean hasChanged;
    
    /**
     * Target folder
     * 
     * @parameter expression="${project.build.directory}/${project.build.finalName}"
     * @since 2.1.9
     */
    private File outputDirectory;
    
    /**
     * The Maven project.
     * 
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;
    
    private List<JarXpatchItem> suspendedPatches;
    
    @SuppressWarnings("unchecked")
    public void execute() throws MojoExecutionException {
        getLog().debug("Compiling pattern for config directory...");
        avalonConfigPattern = Pattern.compile(Matcher.quoteReplacement(avalonConfigDirectory) + ".*",
                                              Pattern.CASE_INSENSITIVE);
        
        getLog().debug("Creating a document cache...");
        documentCache = new DocumentCache();
        suspendedPatches = new ArrayList<JarXpatchItem>();
        
        getLog().debug("Getting list of compile artifacts...");
        Collection<Artifact> artifacts = project.getCompileArtifacts();
        
        hasChanged = false;
        
        getLog().debug("Artifacts found: " + artifacts.size());
        for (Artifact artifact : artifacts) {
            if ("jar".equals(artifact.getType())) {
                processArtifact(artifact.getFile());
            }
        }
        
        if (hasChanged && !suspendedPatches.isEmpty()) {
            getLog().debug("Trying to apply suspended patch files.");
            
            hasChanged = false;
            
            // Create a new list and backup the old
            List<JarXpatchItem> localSuspended = suspendedPatches;
            suspendedPatches = new ArrayList<JarXpatchItem>();
            
            // Process the suspended patches
            for (JarXpatchItem item : localSuspended) {
                processXPatch(item);
            }
        }
        
        if (!suspendedPatches.isEmpty()) {
            // Report the dismissed patches
            for (JarXpatchItem item : suspendedPatches) {
                getLog().debug("Dismissing: " + item.getJarFile().getName() + "/" + item.getEntry().getName());
            }
        }
        getLog().debug("Saving all documents.");
        documentCache.saveAllDocuments(getLog());
    }
    
    
    /**
     * Whether to add a comment indicating where this block of code comes from.
     */
    public void setAddComments(Boolean addComments) {
        this.addComments = addComments.booleanValue();
    }
    
    /** Returns the file name (excluding directories and extension). */
    private String basename(String fileName) {
        int start = fileName.lastIndexOf(FSEP) + 1; // last '/'
        int end = fileName.lastIndexOf("."); // last '.'
        
        if (end == 0) {
            end = fileName.length();
        }
        return fileName.substring(start, end);
    }
    
    private String getAttribute(Element elem, String attrName, boolean replaceProperties) {
        String attr = elem.getAttribute(attrName);
        if (attr == null) {
            return null;
        }
        else if (replaceProperties) {
            return StringHelper.replaceProperties(attr, project.getProperties());
        }
        else {
            return attr;
        }
    }
    
    private boolean patch(final Document configuration, final Document component, final String filename)
            throws DOMException, TransformerException, IOException, MojoExecutionException {
        // Check to see if Document is an xconf-tool document
        Element elem = component.getDocumentElement();
        
        String extension = filename.lastIndexOf(".") > 0 ? filename.substring(filename.lastIndexOf(".") + 1) : "";
        String basename = basename(filename);
        
        if (!elem.getTagName().equals(extension)) {
            throw new MojoExecutionException("Not a valid xpatch file: " + filename);
        }
        
        String replacePropertiesStr = elem.getAttribute("replace-properties");
        
        boolean replaceProperties = !("no".equalsIgnoreCase(replacePropertiesStr) || "false"
                .equalsIgnoreCase(replacePropertiesStr));
        
        // Get 'root' node were 'component' will be inserted into
        String xpath = getAttribute(elem, "xpath", replaceProperties);
        if (xpath == null) {
            throw new IOException("Attribute 'xpath' is required.");
        }
        NodeList nodes = XPathAPI.selectNodeList(configuration, xpath);
        
        // Suspend, because the xpath returned not one node
        if (nodes.getLength() != 1) {
            getLog().debug("Suspending: " + filename);
            return false;
        }
        Node root = nodes.item(0);
        
        // Test that 'root' node satisfies 'component' insertion criteria
        String testPath = getAttribute(elem, "unless-path", replaceProperties);
        if (testPath == null || testPath.length() == 0) {
            // only look for old "unless" attr if unless-path is not present
            testPath = getAttribute(elem, "unless", replaceProperties);
        }
        // Is if-path needed?
        String ifProp = getAttribute(elem, "if-prop", replaceProperties);
        boolean ifValue = false;
        if (ifProp != null && !ifProp.equals("")) {
            ifValue = Boolean.valueOf(project.getProperties().getProperty(ifProp)).booleanValue();
        }
        
        if (ifProp != null && ifProp.length() > 0 && !ifValue) {
            getLog().debug("Skipping: " + filename);
            return false;
        }
        else if (testPath != null && testPath.length() > 0 && XPathAPI.eval(root, testPath).bool()) {
            getLog().debug("Skipping: " + filename);
            return false;
        }
        else {
            // Test if component wants us to remove a list of nodes first
            xpath = getAttribute(elem, "remove", replaceProperties);
            
            if (xpath != null && xpath.length() > 0) {
                nodes = XPathAPI.selectNodeList(configuration, xpath);
                
                for (int i = 0, length = nodes.getLength(); i < length; i++) {
                    Node node = nodes.item(i);
                    Node parent = node.getParentNode();
                    
                    parent.removeChild(node);
                }
            }
            
            // Test for an attribute that needs to be added to an element
            String name = getAttribute(elem, "add-attribute", replaceProperties);
            String value = getAttribute(elem, "value", replaceProperties);
            
            if (name != null && name.length() > 0) {
                if (value == null) {
                    throw new IOException("No attribute value specified for 'add-attribute' " + xpath);
                }
                if (root instanceof Element) {
                    ((Element) root).setAttribute(name, value);
                }
            }
            
            // Override addComments from ant task if specified as an attribute
            String addCommentsAttr = getAttribute(elem, "add-comments", replaceProperties);
            if (addCommentsAttr != null && addCommentsAttr.length() > 0) {
                setAddComments(new Boolean(addCommentsAttr));
            }
            
            // Allow multiple attributes to be added or modified
            if (root instanceof Element) {
                NamedNodeMap attrMap = elem.getAttributes();
                for (int i = 0; i < attrMap.getLength(); ++i) {
                    Attr attr = (Attr) attrMap.item(i);
                    final String addAttr = "add-attribute-";
                    if (attr.getName().startsWith(addAttr)) {
                        String key = attr.getName().substring(addAttr.length());
                        ((Element) root).setAttribute(key, attr.getValue());
                    }
                }
            }
            
            // Test if 'component' provides desired insertion point
            xpath = getAttribute(elem, "insert-before", replaceProperties);
            Node before = null;
            
            if (xpath != null && xpath.length() > 0) {
                nodes = XPathAPI.selectNodeList(root, xpath);
                if (nodes.getLength() == 0) {
                    getLog().error("Error in: " + filename);
                    throw new IOException("XPath (" + xpath + ") returned zero nodes");
                }
                before = nodes.item(0);
            }
            else {
                xpath = getAttribute(elem, "insert-after", replaceProperties);
                if (xpath != null && xpath.length() > 0) {
                    nodes = XPathAPI.selectNodeList(root, xpath);
                    if (nodes.getLength() == 0) {
                        getLog().error("Error in: " + filename);
                        throw new IOException("XPath (" + xpath + ") zero nodes.");
                    }
                    before = nodes.item(nodes.getLength() - 1).getNextSibling();
                }
            }
            
            // Add 'component' data into 'root' node
            getLog().info("Processing: " + filename);
            NodeList componentNodes = component.getDocumentElement().getChildNodes();
            
            if (this.addComments) {
                root.appendChild(configuration.createComment("..... Start configuration from '" + basename + "' "));
                root.appendChild(configuration.createTextNode(NL));
            }
            for (int i = 0; i < componentNodes.getLength(); i++) {
                Node node = configuration.importNode(componentNodes.item(i), true);
                
                if (replaceProperties) {
                    replaceProperties(node);
                }
                if (before == null) {
                    root.appendChild(node);
                }
                else {
                    root.insertBefore(node, before);
                }
            }
            if (this.addComments) {
                root.appendChild(configuration.createComment("..... End configuration from '" + basename + "' "));
                root.appendChild(configuration.createTextNode(NL));
            }
            return true;
        }
        
    }
    
    /**
     * Processes a jar.
     * 
     * @param file
     *                jar file to process
     * @throws MojoExecutionException
     */
    private void processArtifact(File file) throws MojoExecutionException {
        getLog().debug("Processing artifact: " + file);
        try {
            // Create Jar File
            JarFile jar = new JarFile(file);
            
            // Get avalon config files
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (!entry.isDirectory() && avalonConfigPattern.matcher(name).matches()) {
                    
                    // Check the file extension
                    name = name.toLowerCase();
                    String fileToPatch = null;
                    if (name.endsWith(".xmap") || name.endsWith(".xpipe")) {
                        fileToPatch = "sitemap.xmap";
                    }
                    else if (name.endsWith(".xconf")) {
                        fileToPatch = "WEB-INF/cocoon.xconf";
                    }
                    else if (name.endsWith(".xweb")) {
                        fileToPatch = "WEB-INF/web.xml";
                    }
                    else if (name.endsWith(".xlog")) {
                        fileToPatch = "WEB-INF/logkit.xconf";
                    }
                    else if (name.endsWith(".xlog4j")) {
                        fileToPatch = "WEB-INF/log4j.xconf";
                    }
                    // Do the patching
                    if (fileToPatch != null) {
                        JarXpatchItem item = new JarXpatchItem(jar, entry, fileToPatch);
                        processXPatch(item);
                    }
                }
            }
        }
        catch (IOException e) {
            throw new MojoExecutionException("Error accessing jar file: " + file, e);
        }
    }
    
    /**
     * Patches a file with xpatch content.
     * 
     * @param inputStream
     *                stream with xpatch file content
     * @param filePath
     *                relative path to the patched file
     * @throws MojoExecutionException
     *                 Patching error
     * @throws IOException
     * @throws TransformerException
     */
    private void processXPatch(JarXpatchItem item) throws MojoExecutionException {
        File documentFile = new File(outputDirectory.getPath() + File.separatorChar + item.getFileToPatch());
        Document configuration;
        
        try {
            configuration = documentCache.getDocument(documentFile, getLog());
        }
        catch (SAXException e) {
            throw new MojoExecutionException("Error parsing document: " + documentFile, e);
        }
        catch (IOException e) {
            throw new MojoExecutionException("Error reading document: " + documentFile, e);
        }
        Document component;
        try {
            getLog().debug("Parsing xpatch file: " + item.getJarFile().getName() + "/" + item.getEntry().getName());
            component = documentCache.parse(item.getInputStream());
        }
        catch (SAXException e) {
            throw new MojoExecutionException("Error parsing xpatchStream: " + item.getJarFile().getName() + "/"
                    + item.getEntry().getName(), e);
        }
        catch (IOException e) {
            throw new MojoExecutionException("Error reading xpatchStream: " + item.getJarFile().getName() + "/"
                    + item.getEntry().getName(), e);
        }
        
        try {
            if (!patch(configuration, component, item.getEntry().getName())) {
                suspendedPatches.add(item);
                hasChanged |= true;
            }
        }
        catch (DOMException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
        catch (TransformerException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
        catch (IOException e) {
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }
    
    private void replaceProperties(Node n) throws DOMException {
        NamedNodeMap attrs = n.getAttributes();
        if (attrs != null) {
            for (int i = 0; i < attrs.getLength(); i++) {
                Node attr = attrs.item(i);
                attr.setNodeValue(StringHelper.replaceProperties(attr.getNodeValue(), project.getProperties()));
                
            }
        }
        switch (n.getNodeType()) {
            case Node.ATTRIBUTE_NODE:
            case Node.CDATA_SECTION_NODE:
            case Node.TEXT_NODE: {
                n.setNodeValue(StringHelper.replaceProperties(n.getNodeValue(), project.getProperties()));
                break;
            }
            case Node.DOCUMENT_NODE:
            case Node.DOCUMENT_FRAGMENT_NODE:
            case Node.ELEMENT_NODE: {
                Node child = n.getFirstChild();
                while (child != null) {
                    replaceProperties(child);
                    child = child.getNextSibling();
                }
                break;
            }
            default: {
                // ignore all other node types
            }
        }
    }
}
