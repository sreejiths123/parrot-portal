/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.news;

import java.util.Calendar;

import com.parrot.portal.domain.core.IPersistentObject;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public interface INews extends IPersistentObject<Integer> {
    
    /**
     * @return author of news
     */
    IUser getAuthor();
    
    /**
     * @return message for guests
     */
    String getContent();
    
    /**
     * @return date when should be news published
     */
    Calendar getDatePublished();
    
    /**
     * @return creation date
     */
    Calendar getDateWritten();
    
    /**
     * @return hmm....hard to understand ;)
     */
    String getHeadline();
    
    /**
     * @param author
     */
    void setAuthor(IUser author);
    
    /**
     * @param content
     */
    void setContent(String content);
    
    /**
     * @param datePublished
     */
    void setDatePublished(Calendar datePublished);
    
    /**
     * @param dateWritten
     */
    void setDateWritten(Calendar dateWritten);
    
    void setHeadline(String headline);
}
