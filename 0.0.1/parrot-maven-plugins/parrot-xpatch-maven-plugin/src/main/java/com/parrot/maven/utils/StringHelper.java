/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.maven.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author koberale
 */
public class StringHelper {
    
    private static String PROPERTY_NAME_DEF = ".+?";
    
    /**
     * Creates a literal form of a string, that can be used in regular expressions. It escapes all
     * regex special characters which are: <code>([{\$|)?*+</code>
     * 
     * @param s
     *                String to be literalized
     * @return a literalized string
     */
    public static String createLiteralString(final String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                case '\\':
                case '$':
                case '|':
                case ')':
                case '?':
                case '*':
                case '+':
                case '.':
                    sb.append('\\');
                    break;
            }
            sb.append(c);
        }
        return sb.toString();
    }
    
    /**
     * A generic template replace function. Replaces string tokens with values from map. The token
     * can have prefix or suffix. It can use prefix/suffix matching or matching using the map.
     * 
     * @param template
     * @param map
     * @param prefix
     * @param suffix
     * @param useMapForMatching
     * @return
     */
    public static String replace(final String template, final Map<Object, Object> map, final String prefix,
            final String suffix, boolean useMapForMatching) {
        final StringBuilder patternDefinition = new StringBuilder();
        if (prefix != null) {
            patternDefinition.append(createLiteralString(prefix));
        }
        patternDefinition.append("(");
        if (useMapForMatching) {
            for (final Object key : map.keySet()) {
                patternDefinition.append(key);
                patternDefinition.append("|");
                patternDefinition.append("[^\\s\\S]");
            }
        }
        else {
            patternDefinition.append(PROPERTY_NAME_DEF);
        }
        patternDefinition.append(")");
        patternDefinition.append(createLiteralString(suffix));
        
        Pattern pattern = Pattern.compile(patternDefinition.toString());
        Matcher matcher = pattern.matcher(template);
        final StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            final String key = matcher.group(1);
            Object value = map.get(key);
            if (value != null) {
                matcher.appendReplacement(stringBuffer, value.toString());
            }
            else {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(matcher.group()));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
    
    
    /**
     * Replaces a property holder in a string. Property holder is specified as
     * <code>${property.name}</code>. Uses a replace function with specified prefix and suffix
     * and generic propery name matching.
     * 
     * @param template
     * @param map
     * @return
     */
    public static String replaceProperties(final String template, final Map<Object, Object> properties) {
        return replace(template, properties, "${", "}", false);
    }
}
