package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IPersistentObject;


/**
 * @author macekpet
 */
public interface IModule extends IPersistentObject<Integer> {
    
    
    String getName();
    
    void setName(String name);
}
