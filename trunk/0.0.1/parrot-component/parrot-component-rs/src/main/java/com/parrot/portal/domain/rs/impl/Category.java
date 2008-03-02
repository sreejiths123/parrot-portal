package com.parrot.portal.domain.rs.impl;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.rs.ICategory;


/**
 * @author tajzivit
 */
public class Category extends BasicPersistentObject implements ICategory {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8349529351587919417L;
    
    private String description;
    private String name;
    private ICategory parent;
    
    /** {@inheritDoc} */
    public String getDescription() {
        return description;
    }
    
    /** {@inheritDoc} */
    public String getName() {
        return name;
    }
    
    /** {@inheritDoc} */
    public ICategory getParent() {
        return parent;
    }
    
    /** {@inheritDoc} */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /** {@inheritDoc} */
    public void setName(String name) {
        this.name = name;
    }
    
    /** {@inheritDoc} */
    public void setParent(ICategory category) {
        this.parent = category;
    }
}
