/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.maven.xpatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.xml.sax.SAXException;


/**
 * @author koberale
 */
public class DocumentCache {
    
    protected final Map<File, Document> fileCache = new HashMap<File, Document>();
    private DocumentBuilder builder;
    private Transformer transformer;
    
    /**
     * Default constructor that initializes a Parser need to parse the documents.
     * 
     * @throws MojoExecutionException
     * @throws ParserConfigurationException
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerConfigurationException
     */
    public DocumentCache() throws MojoExecutionException {
        super();
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setValidating(false);
            builderFactory.setExpandEntityReferences(false);
            builderFactory.setNamespaceAware(false);
            builderFactory
                    .setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", Boolean.FALSE);
            builder = builderFactory.newDocumentBuilder();
            transformer = TransformerFactory.newInstance().newTransformer();
        }
        catch (TransformerException e) {
            throw new MojoExecutionException("Error initializing document cache.", e);
        }
        catch (ParserConfigurationException e) {
            throw new MojoExecutionException("Error initializing document cache.", e);
        }
    }
    
    /**
     * Retrieves Document either from cache or builds a new one from the file
     * 
     * @param file
     *                the file to read
     * @param log
     *                maven log instance to for debug logging
     * @return parsed document
     * @throws SAXException
     *                 Parsing error in the form of malformed xml
     * @throws IOException
     *                 Can be thrown when accessing the file
     */
    public Document getDocument(final File file, Log log) throws SAXException, IOException {
        Document document = fileCache.get(file);
        if (document != null) {
            log.debug("Using file from cache: " + file);
        }
        else {
            // load xml
            log.debug("Parsing file: " + file);
            document = builder.parse(file);
            fileCache.put(file, document);
        }
        return document;
    }
    
    /**
     * Parses a stream using the internal preconfigured parser.
     * 
     * @param stream
     *                a stream to parse
     * @return Document built from the stream
     * @throws SAXException
     *                 Error parsing stream - malformed XML
     * @throws IOException
     *                 Error accessing the stream
     */
    public Document parse(InputStream stream) throws SAXException, IOException {
        return builder.parse(stream);
    }
    
    /**
     * Saves all documents and erases the cache.
     * 
     * @param log
     *                maven log instance to for debug logging
     * @throws MojoExecutionException
     *                 Error when saving the documents in the cache
     */
    public void saveAllDocuments(Log log) throws MojoExecutionException {
        
        Iterator<Entry<File, Document>> iterator = fileCache.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<File, Document> entry = iterator.next();
            
            log.debug("Saving file: " + entry.getKey());
            
            // Set the DOCTYPE output option on the transformer 
            // if we have any DOCTYPE declaration in the input xml document
            final DocumentType doctype = entry.getValue().getDoctype();
            Properties props = new Properties();
            if (null != doctype) {
                if (null != doctype.getPublicId()) {
                    props.put(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
                }
                if (null != doctype.getSystemId()) {
                    props.put(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
                }
            }
            transformer.setOutputProperties(props);
            
            try {
                StreamResult s = new StreamResult(entry.getKey());
                // for JDK 5.0 we explicitly have to set the output stream
                // otherwise we get FileNotFoundExceptions (at least on
                // windows)
                s.setOutputStream(new FileOutputStream(entry.getKey()));
                transformer.transform(new DOMSource(entry.getValue()), s);
            }
            catch (FileNotFoundException e) {
                throw new MojoExecutionException("Error saving document: " + entry.getKey(), e);
            }
            catch (TransformerException e) {
                throw new MojoExecutionException("Error saving document: " + entry.getKey(), e);
            }
            iterator.remove();
        }
        
    }
    
}
