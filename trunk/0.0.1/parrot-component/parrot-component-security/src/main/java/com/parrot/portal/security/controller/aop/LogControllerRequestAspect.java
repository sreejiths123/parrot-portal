/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.security.controller.aop;

import org.apache.log4j.Logger;


/**
 * @author tajzivit
 */
public class LogControllerRequestAspect {
    
    private static Logger logInternalRequest = Logger.getLogger("Controller.request");
    
    /**
     * method for log internal servlet's requests
     * 
     * @param request
     * @param response
     */
    public void logRequest() {
        logInternalRequest.info("I've got it...");
        System.out.println("mam te.");
    }
}
