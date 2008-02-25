package com.parrot.portal.controller.secure.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.controller.command.CommandType;
import com.parrot.portal.controller.command.user.IModifyRoleCommand;
import com.parrot.portal.controller.command.user.impl.ModifyRoleCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.service.IUserManagementService;
import com.parrot.portal.taglib.CollectionTag;


/**
 * @author tajzivit
 */
public class ModifyRoleController extends AbstractCommandController {
    
    private IDomainFactory domainFactory;
    private String editView;
    private String successView;
    private IUserManagementService userManagementService;
    
    /**
     * @param domainFactory
     *                the domainFactory to set
     */
    public void setDomainFactory(IDomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }
    
    /**
     * @param editView
     *                the editView to set
     */
    public void setEditView(String editView) {
        this.editView = editView;
    }
    
    /**
     * @param viewName
     *                the viewName to set
     */
    public void setSuccessView(String viewName) {
        this.successView = viewName;
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
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException ex) throws Exception {
        
        IModifyRoleCommand roleCommand = (IModifyRoleCommand)command;
        
        if (roleCommand.getType().equals(CommandType.EDIT)) {
            
            doUpdate(roleCommand.getCommand());
            
        } else if (roleCommand.getType().equals(CommandType.REMOVE)) {
            
            doRemove(roleCommand.getCommand());
            
        } else if (CommandType.SHOW_EDIT.equals(roleCommand.getType())) {
            
            List<IRole> collection = (List<IRole>)request.getSession().getAttribute(CollectionTag.LAST_COLLECTION);
            roleCommand.setCommand(collection.get(roleCommand.getId()));
            
            return new ModelAndView(editView, getCommandName(), roleCommand);
        }
        
        return new ModelAndView(new RedirectView(successView));
    }
    
    private void doRemove(IRole role) {
        userManagementService.remove(role);
    }
    
    private void doUpdate(IRole role) {
        userManagementService.update(role);
    }
}
