package com.parrot.portal.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author tajzivit
 */
public class MyController extends SimpleFormController {
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        
        System.out.println("redirecting to success.");
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
