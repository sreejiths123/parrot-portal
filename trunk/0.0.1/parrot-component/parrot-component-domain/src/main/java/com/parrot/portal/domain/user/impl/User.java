package com.parrot.portal.domain.user.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public class User extends BasicPersistentObject implements IUser {
    
    private static final long serialVersionUID = -2162718697275295435L;
    
    @Autowired
    private IContact contact;
    private Set<IRole> roles;
    
    
    public void addRole(IRole role) {
        if (roles == null) {
            roles = new LinkedHashSet<IRole>();
        }
        roles.add(role);
    }
    
    
    /** {@inheritDoc} */
    public IContact getContact() {
        return contact;
    }
    
    public Set<IRole> getRoles() {
        return Collections.unmodifiableSet(roles);
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
