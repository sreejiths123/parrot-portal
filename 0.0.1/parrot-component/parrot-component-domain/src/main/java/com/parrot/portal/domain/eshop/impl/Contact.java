/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.eshop.impl;

import com.parrot.portal.domain.core.IName;
import com.parrot.portal.domain.eshop.IContact;


/**
 * @author tajzivit
 */
public class Contact implements IContact {
    
    private int id;
    private IName name;
    
    /**
     * 
     */
    public Contact() {
        
    }
    
    /** {@inheritDoc} */
    public int getId() {
        return id;
    }
    
    /** {@inheritDoc} */
    public IName getName() {
        return name;
    }
    
    /** {@inheritDoc} */
    public void setId(int id) {
        this.id = id;
    }
    
    /** {@inheritDoc} */
    public void setName(IName name) {
        this.name = name;
    }
    
}
