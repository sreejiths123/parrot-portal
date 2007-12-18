/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core.impl;

import com.parrot.portal.domain.core.IName;


/**
 * @author tajzivit
 */
public class Name implements IName {
    
    private String firstName;
    private String lastName;
    
    /**
     * 
     */
    public Name() {
        
    }
    
    /** {@inheritDoc} */
    public String getFirstName() {
        return firstName;
    }
    
    /** {@inheritDoc} */
    public String getLastName() {
        return lastName;
    }
    
    /** {@inheritDoc} */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /** {@inheritDoc} */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
