package com.parrot.portal.controller.command.user.impl;

import com.parrot.portal.controller.command.user.IModifyUserCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public class ModifyUserCommand extends AbstractParrotCommand<IUser> implements IModifyUserCommand {
    
    /**
     * 
     */
    public ModifyUserCommand(IDomainFactory domainFactory) {
        setCommand(domainFactory.getDomainObject(IUser.class));
    }
}
