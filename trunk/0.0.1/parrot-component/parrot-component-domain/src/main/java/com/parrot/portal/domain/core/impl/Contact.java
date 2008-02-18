/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.core.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.parrot.portal.domain.core.IAddress;
import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.IName;
import com.parrot.portal.domain.core.ITelephone;


/**
 * @author tajzivit
 */
public class Contact implements IContact {
    
    private static final long serialVersionUID = -974010218171182853L;
    
    @Autowired
    private IAddress address;
    @Autowired
    private IName name;
    @Autowired
    private ITelephone telephone;
    
    /** {@inheritDoc} */
    public IAddress getAddress() {
        return address;
    }
    
    /** {@inheritDoc} */
    public IName getName() {
        return name;
    }
    
    /** {@inheritDoc} */
    public ITelephone getTelephone() {
        return telephone;
    }
    
    /** {@inheritDoc} */
    public void setAddress(IAddress address) {
        this.address = address;
    }
    
    /** {@inheritDoc} */
    public void setName(IName name) {
        this.name = name;
    }
    
    /** {@inheritDoc} */
    public void setTelephone(ITelephone telephone) {
        this.telephone = telephone;
    }
}
