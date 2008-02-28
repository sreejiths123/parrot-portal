package com.parrot.portal.controller.secure.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.controller.AbstractParrotSimpleFormController;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
public class AddRoleController extends AbstractParrotSimpleFormController {
    
    private IUserManagementService userManagementService;
    
    /**
     * @param userManagementService
     *                the userManagementService to set
     */
    public void setUserManagementService(IUserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }
    
    /** {@inheritDoc} */
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        
        return getDomainFactory().getDomainObject(IRole.class);
    }
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        
        IRole role = (IRole)command;
        
        userManagementService.insertRole(role);
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
