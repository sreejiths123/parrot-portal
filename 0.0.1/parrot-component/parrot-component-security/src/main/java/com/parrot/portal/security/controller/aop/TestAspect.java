/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.aop;

import org.aspectj.lang.ProceedingJoinPoint;


/**
 * @author tajzivit
 */
public class TestAspect {
    
    public void checkAfter() {
        
        System.out.println("after checking...");
    }
    
    public Object checkAround(ProceedingJoinPoint pjp) throws Throwable {
        
        checkBefore();
        
        Object result = pjp.proceed();
        
        checkAfter();
        
        return result;
    }
    
    public void checkBefore() {
        
        System.out.println("before checking...");
    }
    
    public void checkBefore(Object s) {
        
        System.out.println("before checking with arg: " + s);
    }
}
