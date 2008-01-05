/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.impl;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;



/**
 * @author pema9150
 */
public abstract class ParrotAbstractSpringTest extends AbstractDependencyInjectionSpringContextTests {
    
    @Override
    protected String[] getConfigLocations() {
        return new String[] { "applicationContext.xml" };
    }
    
}
