package com.parrot.portal.controller.command.user.impl;

import com.parrot.portal.controller.command.impl.AbstractParrotCommand;
import com.parrot.portal.controller.command.user.IModifyRoleCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.user.IRole;


/**
 * @author tajzivit
 */
public class ModifyRoleCommand extends AbstractParrotCommand<IRole> implements IModifyRoleCommand {
    
    /**
     * 
     */
    public ModifyRoleCommand(IDomainFactory domainFactory) {
        setObject(domainFactory.getDomainObject(IRole.class));
    }
    
    /** {@inheritDoc} */
    public Integer getObjectsId() {
        return getObject().getId();
    }
    
    /** {@inheritDoc} */
    public void setObjectsId(Integer id) {
        getObject().setId(id);
    }
}
