/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.eshop;

import com.parrot.portal.domain.eshop.impl.Name;


/**
 * @author tajzivit
 */
public interface IContact {
    
    int getId();
    
    IName getName();
    
    void setId(int id);
    
    void setName(IName name);
}
