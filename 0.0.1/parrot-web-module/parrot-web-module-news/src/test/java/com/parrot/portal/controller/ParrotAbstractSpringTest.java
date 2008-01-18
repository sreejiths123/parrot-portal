/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.controller;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;



/**
 * @author pema9150
 */
public abstract class ParrotAbstractSpringTest extends AbstractDependencyInjectionSpringContextTests {
    
    @Override
    protected String[] getConfigLocations() {
        return new String[] { "WEB-INF/parrot-portal-news-servlet.xml" };
    }
    
}
