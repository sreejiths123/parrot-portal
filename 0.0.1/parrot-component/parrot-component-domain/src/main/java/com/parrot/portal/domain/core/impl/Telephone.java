/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core.impl;

import com.parrot.portal.domain.core.ITelephone;


/**
 * @author tajzivit
 */
public class Telephone implements ITelephone {
    
    private static final long serialVersionUID = -3285992649445457404L;
    private String countryPrefix;
    private String localNumber;
    private String number;
    
    /** {@inheritDoc} */
    public String getCountryPrefix() {
        return countryPrefix;
    }
    
    /** {@inheritDoc} */
    public String getCoutryPrefix() {
        return countryPrefix;
    }
    
    /** {@inheritDoc} */
    public String getLocalNumber() {
        return localNumber;
    }
    
    /** {@inheritDoc} */
    public String getNumber() {
        return number;
    }
    
    /** {@inheritDoc} */
    public void setCountryPrefix(String prefix) {
        this.countryPrefix = prefix;
    }
    
    /** {@inheritDoc} */
    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }
    
    /** {@inheritDoc} */
    public void setNumber(String number) {
        this.number = number;
    }
    

}
