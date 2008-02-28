package com.parrot.portal.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * @author tajzivit
 */
public class TextTag extends BodyTagSupport {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2993685455674461806L;
    
    private LinkTag parent;
    
    
    /** {@inheritDoc} */
    @Override
    public int doAfterBody() throws JspException {
        
        parent.setText(getBodyContent().getString());
        
        return SKIP_BODY;
    }
    
    /** {@inheritDoc} */
    @Override
    public int doStartTag() throws JspException {
        
        this.parent = (LinkTag)findAncestorWithClass(this, LinkTag.class);
        
        if (parent == null) {
            return SKIP_BODY;
        }
        
        return EVAL_BODY_AGAIN;
    }
}
