/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core;


/**
 * @author tajzivit
 */
public interface ITelephone {
    
    /**
     * @return telephone number prefix for country (ex. for CZ +420 is returned)
     */
    String getCoutryPrefix();
    
    /**
     * @return local / area number
     */
    String getLocalNumber();
    
    /**
     * @return current user's number
     */
    String getNumber();
    
    /**
     * @param prefix
     */
    void setCountryPrefix(String prefix);
    
    /**
     * @param localNumber
     */
    void setLocalNumber(String localNumber);
    
    /**
     * @param number
     */
    void setNumber(String number);
}
