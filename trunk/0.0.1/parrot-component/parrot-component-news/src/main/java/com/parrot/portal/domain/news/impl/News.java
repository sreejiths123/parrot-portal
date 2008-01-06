/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.news.impl;

import java.util.Calendar;

import com.parrot.portal.domain.news.INews;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public class News implements INews {
    
    private IUser author;
    private String content;
    private Calendar datePublished;
    private Calendar dateWritten;
    private String headline;
    private int id;
    
    /** {@inheritDoc} */
    public IUser getAuthor() {
        return author;
    }
    
    /** {@inheritDoc} */
    public String getContent() {
        return content;
    }
    
    /** {@inheritDoc} */
    public Calendar getDatePublished() {
        return datePublished;
    }
    
    /** {@inheritDoc} */
    public Calendar getDateWritten() {
        return dateWritten;
    }
    
    /** {@inheritDoc} */
    public String getHeadline() {
        return headline;
    }
    
    public int getId() {
        return id;
    }
    
    /** {@inheritDoc} */
    public void setAuthor(IUser author) {
        this.author = author;
    }
    
    /** {@inheritDoc} */
    public void setContent(String content) {
        this.content = content;
    }
    
    /** {@inheritDoc} */
    public void setDatePublished(Calendar datePublished) {
        this.datePublished = datePublished;
    }
    
    /** {@inheritDoc} */
    public void setDateWritten(Calendar dateWritten) {
        this.dateWritten = dateWritten;
    }
    
    /** {@inheritDoc} */
    public void setHeadline(String headline) {
        this.headline = headline;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}
