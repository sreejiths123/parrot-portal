/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.maven.xpatch;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


/**
 * Class holding information about current xpatch item from the jar file. The needed pieces are jar
 * file and entry. Also a file that is to be modified.
 * 
 * @author koberale
 */
public class JarXpatchItem {
    
    JarEntry entry;
    String fileToPatch;
    JarFile jarFile;
    
    
    /**
     * @param jarFile
     * @param entry
     * @param fileToPatch
     */
    public JarXpatchItem(JarFile jarFile, JarEntry entry, String fileToPatch) {
        this.jarFile = jarFile;
        this.entry = entry;
        this.fileToPatch = fileToPatch;
    }
    
    /**
     * @return the entry
     */
    public JarEntry getEntry() {
        return entry;
    }
    
    /**
     * @return the fileToPatch
     */
    public String getFileToPatch() {
        return fileToPatch;
    }
    
    /**
     * Returns an inputstream of the current XPatch.
     * 
     * @return
     * @throws IOException
     */
    public InputStream getInputStream() throws IOException {
        return jarFile.getInputStream(entry);
    }
    
    /**
     * @return the jarFile
     */
    public JarFile getJarFile() {
        return jarFile;
    }
    
    /**
     * @param entry
     *                the entry to set
     */
    public void setEntry(JarEntry entry) {
        this.entry = entry;
    }
    
    /**
     * @param fileToPatch
     *                the fileToPatch to set
     */
    public void setFileToPatch(String fileToPatch) {
        this.fileToPatch = fileToPatch;
    }
    
    /**
     * @param jarFile
     *                the jarFile to set
     */
    public void setJarFile(JarFile jarFile) {
        this.jarFile = jarFile;
    }
    
}
