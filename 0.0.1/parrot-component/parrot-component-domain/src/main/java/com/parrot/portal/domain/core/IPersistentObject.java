package com.parrot.portal.domain.core;

import java.io.Serializable;


/**
 * Base interface for persistent objects with generic identifier.
 * 
 * @author macekpet
 */
public interface IPersistentObject<PK> extends Serializable {
    
    
    PK getId();
    
    void setId(PK id);
    
}
