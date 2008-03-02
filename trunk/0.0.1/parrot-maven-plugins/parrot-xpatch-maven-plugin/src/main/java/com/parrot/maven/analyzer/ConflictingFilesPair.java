/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.maven.analyzer;

import java.util.jar.JarFile;


/**
 * @author koberale
 */
public class ConflictingFilesPair {
    
    /**
     * First Jar file in the conflict
     */
    private JarFile jarFile1;
    /**
     * Second Jar file in the conflict
     */
    private JarFile jarFile2;
    
    /**
     * 
     */
    public ConflictingFilesPair() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @param jarFile1
     * @param jarFile2
     */
    public ConflictingFilesPair(JarFile jarFile1, JarFile jarFile2) {
        this.jarFile1 = jarFile1;
        this.jarFile2 = jarFile2;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConflictingFilesPair other = (ConflictingFilesPair) obj;
        
        if (!equalsNormal(other)) {
            return equalsSwitch(other);
        }
        
        return true;
    }
    
    /**
     * @return the jarFile1
     */
    public JarFile getJarFile1() {
        return jarFile1;
    }
    
    /**
     * @return the jarFile2
     */
    public JarFile getJarFile2() {
        return jarFile2;
    }
    
    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        final int hash1 = jarFile1 == null ? 0 : jarFile1.getName().hashCode();
        final int hash2 = jarFile2 == null ? 0 : jarFile2.getName().hashCode();
        if (hash1 < hash2) {
            result = prime * result + hash1;
            result = prime * result + hash2;
        }
        else {
            result = prime * result + hash2;
            result = prime * result + hash1;
        }
        return result;
    }
    
    /**
     * @param jarFile1
     *                the jarFile1 to set
     */
    public void setJarFile1(JarFile jarFile1) {
        this.jarFile1 = jarFile1;
    }
    
    /**
     * @param jarFile2
     *                the jarFile2 to set
     */
    public void setJarFile2(JarFile jarFile2) {
        this.jarFile2 = jarFile2;
    }
    
    /**
     * @param other
     * @return
     */
    private boolean equalsNormal(ConflictingFilesPair other) {
        if (jarFile1 == null) {
            if (other.jarFile1 != null) {
                return false;
            }
        }
        else if (!jarFile1.equals(other.jarFile1)) {
            return false;
        }
        if (jarFile2 == null) {
            if (other.jarFile2 != null) {
                return false;
            }
        }
        else if (!jarFile2.equals(other.jarFile2)) {
            return false;
        }
        
        return true;
    }
    
    /**
     * @param other
     * @return
     */
    private boolean equalsSwitch(ConflictingFilesPair other) {
        if (jarFile1 == null) {
            if (other.jarFile2 != null) {
                return false;
            }
        }
        else if (!jarFile1.equals(other.jarFile2)) {
            return false;
        }
        if (jarFile2 == null) {
            if (other.jarFile1 != null) {
                return false;
            }
        }
        else if (!jarFile2.equals(other.jarFile1)) {
            return false;
        }
        
        return true;
    }
    

}
