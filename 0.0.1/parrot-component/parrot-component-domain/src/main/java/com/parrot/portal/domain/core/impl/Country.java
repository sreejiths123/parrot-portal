/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core.impl;

import org.springframework.beans.factory.annotation.Configurable;

import com.parrot.portal.domain.core.ICountry;


/**
 * @author tajzivit
 */
@Configurable("domain-country")
public class Country implements ICountry {
    
    private String code;
    private String name;
    
    /** {@inheritDoc} */
    public String getCode() {
        return code;
    }
    
    /** {@inheritDoc} */
    public String getName() {
        return name;
    }
    
    /** {@inheritDoc} */
    public void setCode(String code) {
        this.code = code;
    }
    
    /** {@inheritDoc} */
    public void setName(String name) {
        this.name = name;
    }
}