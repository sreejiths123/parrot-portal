/*******************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 ******************************************************************************/

package com.parrot.eshop.domain;



/**
 * @author macekpet
 *
 */
public interface IModule {
    
    /**
     * @return the id
     */
    int getId();
    
    /**
     * @return the name
     */
    String getName();
    
    /**
     * @param id
     *                the id to set
     */
    void setId(int id);
    
    /**
     * @param name
     *                the name to set
     */
    void setName(String name);
    
}
