package com.parrot.portal.controller.secure.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.factory.impl.DefaultDomainFactory;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
public class AddUserController extends SimpleFormController {
    
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
        
        return getDomainFactory().getDomainObject(IUser.class);
    }
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        
        IUser user = (IUser)command;
        
        userManagementService.insertUser(user);
        
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    private IDomainFactory getDomainFactory() {
        return (IDomainFactory)getApplicationContext().getBean(DefaultDomainFactory.BEAN_NAME);
    }
}
