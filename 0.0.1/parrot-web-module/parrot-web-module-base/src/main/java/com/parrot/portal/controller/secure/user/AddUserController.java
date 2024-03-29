package com.parrot.portal.controller.secure.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.controller.AbstractParrotSimpleFormController;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
public class AddUserController extends AbstractParrotSimpleFormController {
    
    @Autowired
    private IUser user;
    
    private IUserManagementService userManagementService;
    
    /** {@inheritDoc} */
    @Override
    public ModelAndView onSubmit(Object command) throws Exception {
        
        IUser user = (IUser)command;
        
        userManagementService.insertUser(user);
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    /**
     * @param user
     *                the user to set
     */
    public void setUser(IUser user) {
        this.user = user;
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
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        
        return getDomainFactory().getDomainObject(IUser.class);
    }
}
