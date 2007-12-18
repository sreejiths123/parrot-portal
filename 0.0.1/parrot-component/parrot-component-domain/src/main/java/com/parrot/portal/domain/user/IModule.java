package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IPersistentObject;


/**
 * @author macekpet
 */
public interface IModule extends IPersistentObject {
    
    
    String getName();
    
    void setName(String name);
}
