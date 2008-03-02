package com.parrot.portal.controller.secure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


/**
 * @author tajzivit
 */
public abstract class AbstractSecureController extends AbstractController {
    
    /** {@inheritDoc} */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        System.out.println("checking user");
        
        return super.handleRequest(request, response);
    }
}
