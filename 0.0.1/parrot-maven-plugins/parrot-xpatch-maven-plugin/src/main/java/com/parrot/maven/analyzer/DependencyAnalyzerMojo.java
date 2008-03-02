/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.maven.analyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;


/**
 * Goal for analysis of dependent jar files. Traverses thourgh all libraries and check for class and
 * flie duplicates, that may cause problems during the runtime or even compile time.
 * 
 * @goal analyze
 * @since 2.1.9
 * @requiresDependencyResolution compile
 */
public class DependencyAnalyzerMojo extends AbstractMojo {
    
    private static final int FILE_MAP_INITIAL_CAPACITY = 10000;
    
    private static Pattern filePattern = Pattern.compile("(.*\\.class)|(meta-inf/services/.*?[^/])",
                                                         Pattern.CASE_INSENSITIVE);
    
    private static final int JAR_LIST_INITIAL_CAPACITY = 1;
    
    /**
     * Target folder
     * 
     * @parameter default-value=";"
     * @since 2.1.9
     */
    private String columnSeparator;
    
    /**
     * Target filename
     * 
     * @parameter expression="${project.build.directory}/${project.build.finalName}/conflict-files-result.csv"
     * @since 2.1.9
     */
    private File conflictFilesOutput;
    private Set<ConflictingFilesPair> conflictingFiles;
    
    /**
     * Target filename
     * 
     * @parameter expression="${project.build.directory}/${project.build.finalName}/conflict-libs-result.csv"
     * @since 2.1.9
     */
    private File conflictLibsOutput;
    
    private Map<String, List<JarFile>> files;
    

    /**
     * The Maven project.
     * 
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;
    
    @SuppressWarnings("unchecked")
    public void execute() throws MojoExecutionException {
        
        files = new Hashtable<String, List<JarFile>>(FILE_MAP_INITIAL_CAPACITY);
        conflictingFiles = new HashSet<ConflictingFilesPair>();
        
        getLog().debug("Starting file analysis...");
        


        Collection<Artifact> artifacts = project.getCompileArtifacts();
        for (Artifact artifact : artifacts) {
            if ("jar".equals(artifact.getType())) {
                analyzeArtifact(artifact.getFile());
            }
        }
        
        getLog().info("--- Start of analysis result ---");
        try {
            FileWriter writer = new FileWriter(conflictFilesOutput);
            writer.write(MessageFormat.format("\"{1}\"{0}\"{2}\"{0}\r\n", new Object[] { columnSeparator, "File",
                    "Library" }));
            for (Entry<String, List<JarFile>> entry : files.entrySet()) {
                if (entry.getValue().size() > 1) {
                    final List<JarFile> jarList = entry.getValue();
                    
                    // Write log
                    getLog().warn(jarList.size() + " occ.: " + entry.getKey());
                    
                    for (JarFile jarFile : jarList) {
                        // Write Log
                        getLog().warn("- " + jarFile.getName());
                        // Write CSV
                        writer.write(MessageFormat.format("\"{1}\"{0}\"{2}\"{0}\r\n", new Object[] { columnSeparator,
                                entry.getKey(), jarFile.getName() }));
                    }
                    
                    // Add conflicting pairs
                    processConflictingPairs(jarList);
                }
            }
            writer.close();
            getLog().info("--- End of analysis result ---");
            

            getLog().debug("Processing conflicting libraries.");
            writer = new FileWriter(conflictLibsOutput);
            for (ConflictingFilesPair pair : conflictingFiles) {
                final String name1 = pair.getJarFile1().getName();
                final String name2 = pair.getJarFile2().getName();
                
                if (name1.compareTo(name2) == -1) {
                    writer.write(MessageFormat.format("\"{1}\"{0}\"{2}\"{0}\r\n", new Object[] { columnSeparator,
                            name1, name2 }));
                }
                else {
                    writer.write(MessageFormat.format("\"{1}\"{0}\"{2}\"{0}\r\n", new Object[] { columnSeparator,
                            name2, name1 }));
                }
            }
            
            writer.close();
            getLog().debug("End of library processing.");
        }
        catch (IOException e) {
            throw new MojoExecutionException("Cannot write result file.", e);
        }
    }
    
    /**
     * Browses the jar file and saves the content to the files map.
     * 
     * @param file
     * @throws MojoExecutionException
     */
    private void analyzeArtifact(File file) throws MojoExecutionException {
        getLog().debug("Analyzing artifact: " + file);
        // Create Jar File
        try {
            JarFile jar = new JarFile(file);
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                storeEntryInMap(entry, jar);
            }
        }
        catch (IOException e) {
            throw new MojoExecutionException("Content of the jar file, cannot be read: " + file.getPath(), e);
        }
    }
    
    /**
     * @param jarList
     */
    private void processConflictingPairs(List<JarFile> jarList) {
        if (jarList.size() == 2) {
            conflictingFiles.add(new ConflictingFilesPair(jarList.get(0), jarList.get(1)));
        }
        else {
            for (int i = 0; i < jarList.size() - 1; i++) {
                for (int j = i + 1; j < jarList.size(); j++) {
                    conflictingFiles.add(new ConflictingFilesPair(jarList.get(i), jarList.get(j)));
                }
            }
        }
    }
    
    /**
     * @param entry
     * @param jarFile
     */
    private void storeEntryInMap(JarEntry entry, JarFile jarFile) {
        if (filePattern.matcher(entry.getName()).matches()) {
            final String key = entry.getName().toLowerCase();
            List<JarFile> jarList = files.get(key);
            if (jarList == null) {
                jarList = new ArrayList<JarFile>(JAR_LIST_INITIAL_CAPACITY);
                files.put(key, jarList);
            }
            jarList.add(jarFile);
        }
    }
}
