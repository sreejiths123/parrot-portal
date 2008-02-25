/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core;


/**
 * @author tajzivit this class contains information about user
 */
public interface IContact {
    
    /**
     * @return user's address
     */
    IAddress getAddress();
    
    /**
     * @return email
     */
    String getEmail();
    
    /**
     * @return user's name
     */
    IName getName();
    
    /**
     * @return user's telephone
     */
    ITelephone getTelephone();
    
    /**
     * @param address
     */
    void setAddress(IAddress address);
    
    /**
     * @param email
     *                of the user
     */
    void setEmail(String email);
    
    /**
     * @param name
     */
    void setName(IName name);
    
    /**
     * @param telephone
     */
    void setTelephone(ITelephone telephone);
}
