package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IPersistentObject;
import com.parrot.portal.domain.user.impl.TaskAccessRight;


/**
 * @author macekpet
 */
public interface ITask extends IPersistentObject<Integer> {
    
    IModule getModule();
    
    ITaskAccessRight getRight();
    
    /**
     * Gets the fully qualified name of the controller (full package path)
     * 
     * @return String value of the class name
     */
    String getQualifiedName();
    
    void setModule(IModule module);
    
    void setQualifiedName(String name);
    
    void setRight(TaskAccessRight right);
}
