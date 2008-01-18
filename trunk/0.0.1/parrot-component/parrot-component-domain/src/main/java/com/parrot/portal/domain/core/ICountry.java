/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core;


/**
 * @author tajzivit
 */
public interface ICountry {
    
    /**
     * @return code of country (ex. CZ for Czech Republic)
     */
    String getCode();
    
    /**
     * @return name of country
     */
    String getName();
    
    /**
     * @param code
     *                of country (ex. CZ for Czech Republic)
     */
    void setCode(String code);
    
    /**
     * @param name
     */
    void setName(String name);
}
