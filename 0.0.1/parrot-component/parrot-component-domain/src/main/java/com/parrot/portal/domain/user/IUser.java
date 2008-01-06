package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IName;
import com.parrot.portal.domain.core.IPersistentObject;


/**
 * @author macekpet
 */
public interface IUser extends IPersistentObject {
    
    /**
     * @return name of current user
     */
    IName getName();
    
    /**
     * @param name
     *                name of current user
     */
    void setName(IName name);
}
