/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.controller.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author tajzivit
 */
public class ControllerAspect {
    
    /**
     * @param request
     * @param response
     */
    public void interceptHandleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        
        System.out.println("We have catched 'handleRequestInternal'");
    }
}
