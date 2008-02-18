/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * @author tajzivit
 */
public class LogControllerRequestAspect {
    
    private static Logger logInternalRequest = Logger.getLogger("Controller.internalRequest");
    
    /**
     * method for log internal servlet's requests
     * 
     * @param request
     * @param response
     */
    public void logInternalRequest(HttpServletRequest request, HttpServletResponse response) {
        logInternalRequest.info("I've got it...");
    }
}
