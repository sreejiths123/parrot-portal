package com.parrot.portal.controller;

import org.springframework.web.servlet.mvc.AbstractController;


/**
 * @author tajzivit
 */
public abstract class AbstractParrotController extends AbstractController {
    
    protected String modelName;
    protected String viewName;
    
    
    /**
     * @param modelName
     *                the modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    
    /**
     * @param viewName
     *                the viewName to set
     */
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
    
}
