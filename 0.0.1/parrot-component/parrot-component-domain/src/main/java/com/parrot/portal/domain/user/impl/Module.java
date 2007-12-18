package com.parrot.portal.domain.user.impl;

import com.parrot.portal.domain.user.IModule;


/**
 * @author macekpet
 */
public class Module implements IModule {
    
    private int id;
    private String name;
    
    /** {@inheritDoc} */
    public int getId() {
        return id;
    }
    
    /** {@inheritDoc} */
    public String getName() {
        return name;
    }
    
    /** {@inheritDoc} */
    public void setId(int id) {
        this.id = id;
    }
    
    /** {@inheritDoc} */
    public void setName(String name) {
        this.name = name;
    }
    
}
