/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.maven.analyzer;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.jar.JarFile;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


/**
 * @author koberale
 */
public class ConflictingFilesPairTest {
    
    private static final String JAR_FILE_PATH1 = "/aopalliance-1.0.jar";
    private static final String JAR_FILE_PATH2 = "/wagon-file-1.0-alpha-7.jar";
    
    private JarFile jarFile1;
    private JarFile jarFile2;
    
    /**
     * Setup method for all tests. Configures the need jarFiles.
     * 
     * @throws IOException
     * @throws URISyntaxException
     */
    @Before
    public void setUp() throws IOException, URISyntaxException {
        jarFile1 = new JarFile(new File(getClass().getResource(JAR_FILE_PATH1).toURI()));
        jarFile2 = new JarFile(new File(getClass().getResource(JAR_FILE_PATH2).toURI()));
    }
    
    /**
     * Test method for
     * {@link no.netcom.maven.analyzer.ConflictingFilesPair#equals(java.lang.Object)}.
     * 
     * @throws IOException
     */
    @Test
    public void testEqualsObject() throws IOException {
        ConflictingFilesPair pair1 = new ConflictingFilesPair();
        ConflictingFilesPair pair2 = new ConflictingFilesPair();
        
        // Set pair 1
        pair1.setJarFile1(jarFile1);
        pair1.setJarFile2(jarFile2);
        
        // Set pair 2
        pair2.setJarFile1(jarFile1);
        pair2.setJarFile2(jarFile2);
        
        // Test normal equality
        Assert.assertEquals(pair1, pair2);
        
    }
    
    /**
     * Test method for {@link no.netcom.maven.analyzer.ConflictingFilesPair#hashCode()}.
     * 
     * @throws IOException
     */
    @Test
    public void testHashCode() throws IOException {
        ConflictingFilesPair pair1 = new ConflictingFilesPair();
        ConflictingFilesPair pair2 = new ConflictingFilesPair();
        
        // Set pair 1
        pair1.setJarFile1(jarFile1);
        pair1.setJarFile2(jarFile2);
        
        // Set pair 2
        pair2.setJarFile1(jarFile1);
        pair2.setJarFile2(jarFile2);
        
        // Test normal equality
        Assert.assertEquals(pair1.hashCode(), pair2.hashCode());
        
    }
    
    /**
     * Test method for
     * {@link no.netcom.maven.analyzer.ConflictingFilesPair#equals(java.lang.Object)}.
     * 
     * @throws IOException
     */
    @Test
    public void testSwitchedEqualsObject() throws IOException {
        ConflictingFilesPair pair1 = new ConflictingFilesPair();
        ConflictingFilesPair pair2 = new ConflictingFilesPair();
        
        // Set pair 1
        pair1.setJarFile1(jarFile1);
        pair1.setJarFile2(jarFile2);
        
        // Set pair 2
        pair2.setJarFile1(jarFile2);
        pair2.setJarFile2(jarFile1);
        
        // Test normal equality
        Assert.assertEquals(pair1, pair2);
    }
    
    /**
     * Test method for {@link no.netcom.maven.analyzer.ConflictingFilesPair#hashCode()}.
     * 
     * @throws IOException
     */
    @Test
    public void testSwitchedHashCode() throws IOException {
        ConflictingFilesPair pair1 = new ConflictingFilesPair();
        ConflictingFilesPair pair2 = new ConflictingFilesPair();
        
        // Set pair 1
        pair1.setJarFile1(jarFile1);
        pair1.setJarFile2(jarFile2);
        
        // Set pair 2
        pair2.setJarFile1(jarFile2);
        pair2.setJarFile2(jarFile1);
        
        // Test normal equality
        Assert.assertEquals(pair1.hashCode(), pair2.hashCode());
        
    }
}
