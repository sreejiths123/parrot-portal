package com.parrot.portal.rs.domain;

import java.util.Calendar;

import com.parrot.portal.domain.core.IPersistentObject;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public interface IArticle extends IPersistentObject<Integer> {
    
    /**
     * @return
     */
    IUser getApprover();
    
    /**
     * @return
     */
    IUser getAuthor();
    
    /**
     * @return category of the article
     */
    ICategory getCategory();
    
    /**
     * @return
     */
    Calendar getDateOfIssue();
    
    /**
     * @return article's description
     */
    String getDescription();
    
    /**
     * @return article's name
     */
    String getName();
    
    /**
     * @param user
     */
    void setApprover(IUser user);
    
    /**
     * @param user
     */
    void setAuthor(IUser user);
    
    /**
     * @param category
     *                of the article
     */
    void setCategory(ICategory category);
    
    /**
     * @param dateOfIssue
     */
    void setDateOfIssue(Calendar dateOfIssue);
    
    /**
     * @param description
     */
    void setDescription(String description);
    
    /**
     * @param name
     */
    void setName(String name);
}
