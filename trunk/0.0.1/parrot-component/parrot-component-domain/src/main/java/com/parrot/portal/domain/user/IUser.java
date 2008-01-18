package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.IPersistentObject;


/**
 * @author macekpet
 */
public interface IUser extends IPersistentObject<Integer> {
    
    /**
     * @return information about current user
     */
    IContact getContact();
    
    /**
     * @param contact
     *                information about current user
     */
    void setContact(IContact contact);
}
