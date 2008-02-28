package com.parrot.portal.controller.command.user.impl;

import java.util.List;

import com.parrot.portal.controller.command.impl.AbstractParrotCommand;
import com.parrot.portal.controller.command.user.IModifyUserCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public class ModifyUserCommand extends AbstractParrotCommand<IUser> implements IModifyUserCommand {
    
    private List<IRole> roleList;
    
    /**
     * 
     */
    public ModifyUserCommand(IDomainFactory domainFactory) {
        setObject(domainFactory.getDomainObject(IUser.class));
    }
    
    /** {@inheritDoc} */
    public Integer getObjectsId() {
        return getObject().getId();
    }
    
    /** {@inheritDoc} */
    public List<IRole> getRoles() {
        return roleList;
    }
    
    /** {@inheritDoc} */
    public void setObjectsId(Integer id) {
        getObject().setId(id);
    }
    
    /** {@inheritDoc} */
    public void setRoles(List<IRole> roleList) {
        this.roleList = roleList;
    }
}
