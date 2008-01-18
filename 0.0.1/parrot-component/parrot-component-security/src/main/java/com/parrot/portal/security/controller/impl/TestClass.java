/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.impl;

import com.parrot.portal.security.controller.ITestClass;
import com.parrot.portal.security.controller.aop.TestAnnotation;


/**
 * @author tajzivit
 */
public class TestClass implements ITestClass {
    
    /**
     * 
     */
    @TestAnnotation
    public void anotherAnnotatiedMethod() {
        System.out.println("annot...");
    }
    
    /** {@inheritDoc} */
    @TestAnnotation
    public void anotherAnnotatiedMethodWithArg(String arg0) {
        System.out.println("inside method with annotation: " + arg0);
    }
    
    /** {@inheritDoc} */
    public void someMethod() {
        System.out.println("doing it...");
    }
    
    /** {@inheritDoc} */
    public void someMethodWithArgs(String arg0) {
        System.out.println("inside method " + arg0);
    }
}
