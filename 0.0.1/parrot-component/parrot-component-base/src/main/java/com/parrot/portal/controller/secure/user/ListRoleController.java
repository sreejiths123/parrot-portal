package com.parrot.portal.controller.secure.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.parrot.portal.controller.AbstractParrotController;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.service.IUserManagementService;


/**
 * @author tajzivit
 */
public class ListRoleController extends AbstractParrotController {
    
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
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        

        List<IRole> roles = userManagementService.listRole();
        
        return new ModelAndView(viewName, modelName, roles);
    }
}
