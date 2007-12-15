/*******************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 ******************************************************************************/

package com.parrot.eshop.domain;




/**
 * @author macekpet
 *
 */
public interface ITask {
    
    /**
     * @return the description
     */
    String getDescription();
    
    /**
     * @return the id
     */
    int getId();
    
    /**
     * @return the module
     */
    IModule getModule();
    
    /**
     * @return the name
     */
    String getName();
    
    /**
     * @return the authenticationRequired
     */
    boolean isAuthenticationRequired();
    
    /**
     * @param authenticationRequired
     *                the authenticationRequired to set
     */
    void setAuthenticationRequired(boolean authenticationRequired);
    
    /**
     * @param description
     *                the description to set
     */
    void setDescription(String description);
    
    /**
     * @param id
     *                the id to set
     */
    void setId(int id);
    
    /**
     * @param module
     *                the module to set
     */
    void setModule(IModule module);
    
    /**
     * @param name
     *                the name to set
     */
    void setName(String name);
    
}
