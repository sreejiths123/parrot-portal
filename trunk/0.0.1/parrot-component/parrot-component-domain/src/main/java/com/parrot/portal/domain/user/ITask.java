package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IPersistentObject;


/**
 * @author macekpet
 */
public interface ITask extends IPersistentObject {
    
    IModule getModule();
    
    /**
     * Gets the fully qualified name of the controller (full package path)
     * 
     * @return String value of the class name
     */
    String getQualifiedName();
    
    void setModule(IModule module);
    
    void setQualifiedName(String name);
}
