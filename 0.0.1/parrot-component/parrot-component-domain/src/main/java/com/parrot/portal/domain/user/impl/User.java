package com.parrot.portal.domain.user.impl;

import org.springframework.beans.factory.annotation.Configurable;

import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
@Configurable("domain-user")
public class User extends BasicPersistentObject implements IUser {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2162718697275295435L;
    private IContact contact;
    
    /** {@inheritDoc} */
    public IContact getContact() {
        return contact;
    }
    
    
    /** {@inheritDoc} */
    public void setContact(IContact contact) {
        this.contact = contact;
    }
    
    /** {@inheritDoc} */
    @Override
    public void setId(Integer id) {
        super.setId(id);
    }
}
