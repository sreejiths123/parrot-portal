/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @author tajzivit
 */
@Aspect
public class TestAnnotationAspect {
    
    @Before("testPointcutWithoutArgs()")
    public void doSomething() {
        System.out.println("before with new aspect");
    }
    
    @Before("testPointcutWithArgs(s)")
    public void doSomethingWithArgs(String s) {
        
        System.out.println("given arg: " + s);
    }
    
    @Pointcut("execution(* com.parrot.portal.controller.secure..onSubmit(java.lang.Object)) && args(command)")
    public void checkController(Object command) {
        
    }
    
    @Before("checkController(command)")
    public void checkControllerAdvice(Object command) {
        System.out.println("given command is type of: " + command.getClass());
    }
    
    /**
     * @param s
     */
    @Pointcut("execution(* com.parrot.portal.security.controller.impl..someMethodWithArgs(java.lang.String)) && args(s)")
    public void testPointcutWithArgs(String s) {
    }
    
    @Pointcut("execution(* com.parrot.portal.security.controller.impl..someMethod())")
    public void testPointcutWithoutArgs() {
        
    };
}
