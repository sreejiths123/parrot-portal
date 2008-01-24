package com.parrot.portal.domain.user.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Configurable;

import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IRole;
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
    private Set<IRole> roles;
    
    
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


	public void addRole(IRole role) {
		if(roles == null){
			roles = new LinkedHashSet<IRole>();
		}
		roles.add(role);		
	}


	public Set<IRole> getRoles() {
		return roles;
	}
}
