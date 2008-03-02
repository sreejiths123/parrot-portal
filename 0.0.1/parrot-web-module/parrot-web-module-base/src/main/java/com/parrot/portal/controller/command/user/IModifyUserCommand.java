package com.parrot.portal.controller.command.user;

import java.util.List;

import com.parrot.portal.controller.command.IParrotCommand;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public interface IModifyUserCommand extends IParrotCommand<IUser> {
    
    /**
     * @return all the roles
     */
    List<IRole> getRoles();
    
    /**
     * @param roleList
     */
    void setRoles(List<IRole> roleList);
}
