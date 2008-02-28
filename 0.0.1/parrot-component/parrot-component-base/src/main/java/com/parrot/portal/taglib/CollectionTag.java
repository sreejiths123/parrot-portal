package com.parrot.portal.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.parrot.portal.exception.LogicalErrorException;


/**
 * @author tajzivit
 */
public class CollectionTag extends TagSupport {
    
    /**
     * 
     */
    public static final String LAST_COLLECTION = "parrot.tag.link.last_collection";
    /**
     * 
     */
    private static final long serialVersionUID = 7481017392225630887L;
    

    private List<?> collection;
    
    /** {@inheritDoc} */
    @Override
    public int doStartTag() throws JspException {
        
        this.pageContext.getSession().setAttribute(LAST_COLLECTION, collection);
        
        return SKIP_BODY;
    }
    
    
    public List<?> getCollection() {
        return collection;
    }
    
    
    public void setCollection(List<?> collection) {
        this.collection = collection;
    }
    

}
