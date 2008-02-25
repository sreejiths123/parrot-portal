package com.parrot.portal.controller;

import org.springframework.web.servlet.mvc.AbstractCommandController;


/**
 * @author tajzivit
 */
public abstract class AbstractParrotCommandController extends AbstractCommandController {
    
    private String editView;
    private String successView;
    
    
    /**
     * @return the editView
     */
    public String getEditView() {
        return editView;
    }
    
    /**
     * @return the successView
     */
    public String getSuccessView() {
        return successView;
    }
    
    
    /**
     * @param editView
     *                the editView to set
     */
    public void setEditView(String editView) {
        this.editView = editView;
    }
    
    /**
     * @param successView
     *                the successView to set
     */
    public void setSuccessView(String successView) {
        this.successView = successView;
    }
}
