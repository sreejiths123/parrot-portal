package com.parrot.portal.domain.rs.impl;

import java.util.Calendar;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.rs.IArticle;
import com.parrot.portal.domain.rs.ICategory;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public class Article extends BasicPersistentObject implements IArticle {
    
    /**
     * 
     */
    private static final long serialVersionUID = -747516866962756387L;
    
    private IUser approver;
    private IUser author;
    private ICategory category;
    private Calendar dateOfIssue;
    private String description;
    private String name;
    
    /** {@inheritDoc} */
    public IUser getApprover() {
        return approver;
    }
    
    /** {@inheritDoc} */
    public IUser getAuthor() {
        return author;
    }
    
    /** {@inheritDoc} */
    public ICategory getCategory() {
        return category;
    }
    
    /** {@inheritDoc} */
    public Calendar getDateOfIssue() {
        return dateOfIssue;
    }
    
    /** {@inheritDoc} */
    public String getDescription() {
        return description;
    }
    
    /** {@inheritDoc} */
    public String getName() {
        return name;
    }
    
    /** {@inheritDoc} */
    public void setApprover(IUser user) {
        this.approver = user;
    }
    
    /** {@inheritDoc} */
    public void setAuthor(IUser user) {
        this.author = user;
    }
    
    /** {@inheritDoc} */
    public void setCategory(ICategory category) {
        this.category = category;
    }
    
    /** {@inheritDoc} */
    public void setDateOfIssue(Calendar dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
    
    /** {@inheritDoc} */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /** {@inheritDoc} */
    public void setName(String name) {
        this.name = name;
    }
}
