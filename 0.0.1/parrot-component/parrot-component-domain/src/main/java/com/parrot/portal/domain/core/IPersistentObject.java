package com.parrot.portal.domain.core;

import java.io.Serializable;


/**
 * Base interface for persistent objects with generic identifier.
 * 
 * @author macekpet
 */
public interface IPersistentObject<PK> extends Serializable {
    
    
    /**
     * @return primary key
     */
    PK getId();
    
    /**
     * @param id
     *                primary key
     */
    void setId(PK id);
    
}
