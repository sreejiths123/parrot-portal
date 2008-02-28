package com.parrot.portal.rs.domain;

import com.parrot.portal.domain.core.IPersistentObject;


/**
 * @author tajzivit
 */
public interface ICategory extends IPersistentObject<Integer> {
    
    /**
     * @return
     */
    String getDescription();
    
    /**
     * @return name of the category
     */
    String getName();
    
    /**
     * @return parent category
     */
    ICategory getParent();
    
    /**
     * @param description
     */
    void setDescription(String description);
    
    /**
     * @param name
     *                of the category
     */
    void setName(String name);
    
    /**
     * @param category
     *                parent category
     */
    void setParent(ICategory category);
}
