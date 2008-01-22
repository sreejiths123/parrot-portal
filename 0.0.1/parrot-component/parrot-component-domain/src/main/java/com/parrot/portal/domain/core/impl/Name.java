/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core.impl;

import org.springframework.beans.factory.annotation.Configurable;

import com.parrot.portal.domain.core.IName;


/**
 * @author tajzivit
 */
@Configurable("domain-name")
public class Name implements IName {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2955401154982595504L;
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
