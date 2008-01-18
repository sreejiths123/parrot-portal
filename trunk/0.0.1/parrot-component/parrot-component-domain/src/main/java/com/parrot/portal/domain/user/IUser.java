package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IPersistentObject;


/**
 * @author macekpet
 */
public interface IUser extends IPersistentObject<Integer> {
    
    /**
     * @return name of current user
     */
    String getFirstName();
    
    /**
     * @param name
     *                name of current user
     */
    void setFirstName(String firstName);
}
