/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * @author tajzivit
 */
public class ApplicationTag extends BodyTagSupport {
    
    /**
     * 
     */
    private static final long serialVersionUID = -4395395150154884963L;
    
    private String id;
    private String window;
    
    /** {@inheritDoc} */
    @Override
    public int doAfterBody() throws JspException {
        

        return SKIP_BODY;
    }
    
    /** {@inheritDoc} */
    @Override
    public int doEndTag() throws JspException {
        
        return EVAL_PAGE;
    }
    
    /** {@inheritDoc} */
    @Override
    public void doInitBody() throws JspException {
        

    }
    
    /** {@inheritDoc} */
    @Override
    public int doStartTag() throws JspException {
        
        if (isEmpty(id) || isEmpty(window)) {
            return SKIP_BODY;
        }
        


        return EVAL_BODY_AGAIN;
    }
    
    /** {@inheritDoc} */
    @Override
    public String getId() {
        return id;
    }
    
    /**
     * @return
     */
    public String getWindow() {
        return window;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @param window
     */
    public void setWindow(String window) {
        this.window = window;
    }
    
    /**
     * @param s
     * @return true if s == null or ""
     */
    private boolean isEmpty(String s) {
        
        return s == null || s.equals("");
    }
}
