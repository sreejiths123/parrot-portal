package com.parrot.portal.domain.user.impl;

import java.util.Set;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.IUser;

/**
 * @author tajzivit
 */
public class Role extends BasicPersistentObject implements IRole {
    
    /**
     * 
     */
    private static final long serialVersionUID = 8734971203599582474L;
    private String name;
    private Set<IUser> users;
    
    public void addUser(IUser user) {
        users.add(user);
    }
    
    /* (non-Javadoc)
     * @see com.parrot.portal.domain.core.impl.IRole#getName()
     */
    public String getName() {
        return name;
    }
    
    public Set<IUser> getUsers() {
        return users;
    }
    
    /* (non-Javadoc)
     * @see com.parrot.portal.domain.core.impl.IRole#setName(java.lang.String)
     */
    public void setName(String name) {
        this.name = name;
    }
    


}
