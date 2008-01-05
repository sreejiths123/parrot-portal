/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.parrot.portal.security.controller.ITestClass;


/**
 * @author tajzivit
 */
public class TestClassTest extends ParrotAbstractSpringTest {
    
    /**
     * Test method for {@link com.parrot.portal.security.controller.impl.TestClass#someMethod()}.
     */
    @Test
    public void testSomeMethod() {
        
        ApplicationContext context = getApplicationContext();
        
        ITestClass testClass = (ITestClass)context.getBean("whoua");
        
        assertNotNull(testClass);
        
        testClass.someMethod();
        
        testClass.someMethodWithArgs("joj");
    }
    
}
