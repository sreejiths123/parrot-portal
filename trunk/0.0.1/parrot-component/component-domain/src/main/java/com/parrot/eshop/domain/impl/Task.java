package com.parrot.eshop.domain.impl;

import com.parrot.eshop.domain.IModule;
import com.parrot.eshop.domain.ITask;


/**
 * @author macekpet
 */
public class Task implements ITask {
    
    private boolean authenticationRequired;
    private String description;
    private int id;
    private IModule module;
    private String name;
    
     /** {@inheritDoc} */
    public String getDescription() {
        return description;
    }
    
     /** {@inheritDoc} */
    public int getId() {
        return id;
    }
    
     /** {@inheritDoc} */
    public IModule getModule() {
        return module;
    }
    
     /** {@inheritDoc} */
    public String getName() {
        return name;
    }
    
     /** {@inheritDoc} */
    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }
    
     /** {@inheritDoc} */
    public void setAuthenticationRequired(boolean authenticationRequired) {
        this.authenticationRequired = authenticationRequired;
    }
    
     /** {@inheritDoc} */
    public void setDescription(String description) {
        this.description = description;
    }
    
     /** {@inheritDoc} */
    public void setId(int id) {
        this.id = id;
    }
    
     /** {@inheritDoc} */
    public void setModule(IModule module) {
        this.module = module;
    }
    
     /** {@inheritDoc} */
    public void setName(String name) {
        this.name = name;
    }
    


}
