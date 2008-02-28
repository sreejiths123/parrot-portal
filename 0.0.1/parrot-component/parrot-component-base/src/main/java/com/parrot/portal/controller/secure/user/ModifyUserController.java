package com.parrot.portal.controller.secure.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.parrot.portal.controller.command.CommandType;
import com.parrot.portal.controller.command.user.IModifyUserCommand;
import com.parrot.portal.controller.command.user.impl.ModifyUserCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
public class ModifyUserController extends AbstractModifyController<IUser> {
    
    private IDomainFactory domainFactory;
    private IUserManagementService userManagementService;
    
    /** {@inheritDoc} */
    @Override
    public void doRemove(IUser user) {
        userManagementService.remove(user);
    }
    
    /** {@inheritDoc} */
    @Override
    public void doUpdate(IUser user) {
        userManagementService.update(user);
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
        return new ModifyUserCommand(domainFactory);
    }
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object cmd, BindException ex)
            throws Exception {
        
        IModifyUserCommand command = (IModifyUserCommand)cmd;
        if (command.getType().equals(CommandType.SHOW_EDIT)) {
            command.setRoles(userManagementService.listRole());
        }
        
        return super.handle(request, response, cmd, ex);
    }
}
