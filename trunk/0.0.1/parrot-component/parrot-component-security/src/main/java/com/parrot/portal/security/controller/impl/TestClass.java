/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.impl;

import com.parrot.portal.security.controller.ITestClass;


/**
 * @author tajzivit
 */
public class TestClass implements ITestClass {
    
    /** {@inheritDoc} */
    public void someMethod() {
        System.out.println("doing it...");
    }
    
    /** {@inheritDoc} */
    public void someMethodWithArgs(String arg0) {
        System.out.println("inside method " + arg0);
    }
}
