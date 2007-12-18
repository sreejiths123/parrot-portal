package com.parrot.portal.domain.core;


/**
 * Base interface for persistent objects with simple identifier. Integer (autoincrement) is used for
 * distinguishing instances.
 * 
 * @author macekpet
 */
public interface IPersistentObject {
    
    
    int getId();
    
    void setId(int id);
    
}
