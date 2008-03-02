package com.parrot.portal.controller.secure.user;

import javax.servlet.http.HttpServletRequest;

import com.parrot.portal.controller.command.user.impl.ModifyRoleCommand;
import com.parrot.portal.controller.secure.AbstractModifyController;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
public class ModifyRoleController extends AbstractModifyController<IRole> {
    
    private IDomainFactory domainFactory;
    private IUserManagementService userManagementService;
    
    @Override
    public void doRemove(IRole role) {
        userManagementService.remove(role);
    }
    
    @Override
    public void doUpdate(IRole role) {
        userManagementService.update(role);
    }
    
    /**
     * @param domainFactory
     *                the domainFactory to set
     */
    public void setDomainFactory(IDomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }
    
    /**
     * @param userManagementService
     *                the userManagementService to set
     */
    public void setUserManagementService(IUserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }
    
    /** {@inheritDoc} */
    @Override
    protected Object getCommand(HttpServletRequest request) throws Exception {
        return new ModifyRoleCommand(domainFactory);
    }
}
