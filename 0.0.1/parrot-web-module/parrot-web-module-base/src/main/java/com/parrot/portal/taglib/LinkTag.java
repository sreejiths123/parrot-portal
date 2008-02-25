package com.parrot.portal.taglib;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import com.parrot.portal.controller.command.CommandType;


/**
 * @author tajzivit
 */
public class LinkTag extends BodyTagSupport {
    
    /**
     * 
     */
    private static final long serialVersionUID = 2206509529531747171L;
    
    private boolean evalBody = true;
    private int idInCollection;
    private String text;
    private CommandType type;
    
    private String url;
    
    /** {@inheritDoc} */
    @Override
    public int doEndTag() throws JspException {
        
        if (url == null || text == null) {
            return EVAL_PAGE;
        }
        
        String urlFormat = "<a href=\"{0}?id={1}&type={2}\" >{3}</a>";
        
        String ahref = MessageFormat.format(urlFormat, url, idInCollection, type.name(), text);
        
        JspWriter writer = pageContext.getOut();
        try {
            writer.write(ahref);
            writer.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return EVAL_PAGE;
    }
    
    /** {@inheritDoc} */
    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_AGAIN;
    }
    
    public int getIdInCollection() {
        return idInCollection;
    }
    
    public String getText() {
        return text;
    }
    
    public String getType() {
        return type.name();
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setIdInCollection(int idInCollection) {
        this.idInCollection = idInCollection;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public void setType(String type) {
        this.type = CommandType.valueOf(CommandType.class, type);
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
}
