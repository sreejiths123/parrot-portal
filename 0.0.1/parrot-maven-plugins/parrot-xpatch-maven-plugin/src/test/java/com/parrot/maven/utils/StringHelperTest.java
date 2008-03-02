/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.maven.utils;

import java.util.Hashtable;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author koberale
 */
public class StringHelperTest {
    
    private Map<Object, Object> map;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        map = new Hashtable<Object, Object>();
    }
    
    @Test
    public void testReplaceEmptyMap() {
        String template = "This is ${first.word} and ${second.word}.";
        String result = StringHelper.replaceProperties(template, map);
        Assert.assertEquals("This is ${first.word} and ${second.word}.", result);
    }
    
    @Test
    public void testReplaceIncompleteMap() {
        String template = "This is ${first.word} and ${second.word}.";
        map.put("first.word", "Tommy");
        String result = StringHelper.replaceProperties(template, map);
        Assert.assertEquals("This is Tommy and ${second.word}.", result);
    }
    
    /**
     * Test method for
     * {@link no.netcom.maven.utils.StringHelper#replace(java.lang.String, java.util.Map)}.
     */
    @Test
    public void testReplaceMultiple() {
        String template = "This is ${first.word} and ${second.word}.";
        map.put("first.word", "Tommy");
        map.put("second.word", "Jim");
        String result = StringHelper.replaceProperties(template, map);
        Assert.assertEquals("This is Tommy and Jim.", result);
    }
    
    /**
     * Test method for
     * {@link no.netcom.maven.utils.StringHelper#replace(java.lang.String, java.util.Map)}.
     */
    @Test
    public void testReplaceNone() {
        String template = "Nothing should be replaced.";
        map.put("first.word", "Tommy");
        map.put("second.word", "Jim");
        String result = StringHelper.replaceProperties(template, map);
        Assert.assertEquals("Nothing should be replaced.", result);
    }
    
    /**
     * Test method for
     * {@link no.netcom.maven.utils.StringHelper#replace(java.lang.String, java.util.Map)}.
     */
    @Test
    public void testReplaceOne() {
        String template = "Replace {${this}}.";
        map.put("this", "one word");
        String result = StringHelper.replaceProperties(template, map);
        Assert.assertEquals("Replace {one word}.", result);
    }
}
