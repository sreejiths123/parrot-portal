package com.parrot.portal.controller.secure.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.parrot.portal.controller.AbstractParrotController;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
public class ListUserController extends AbstractParrotController {
    
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
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        
        List<IUser> users = userManagementService.list();
        
        return new ModelAndView(viewName, modelName, users);
    }
}
