/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core;


/**
 * @author tajzivit
 */
public interface IName {
    
    /**
     * @return user's first name
     */
    String getFirstName();
    
    /**
     * @return user's last name
     */
    String getLastName();
    
    /**
     * @param firstName
     */
    void setFirstName(String firstName);
    
    /**
     * @param lastName
     */
    void setLastName(String lastName);
}
