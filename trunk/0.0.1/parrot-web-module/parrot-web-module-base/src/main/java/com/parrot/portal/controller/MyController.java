package com.parrot.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.parrot.portal.domain.core.IContact;

/**
 * @author tajzivit
 */
public class MyController extends SimpleFormController {
    
    @Autowired
    private IContact contact;
    
    /**
     * @param contact
     *                the contact to set
     */
    public void setContact(IContact contact) {
        this.contact = contact;
    }
    
    /** {@inheritDoc} */
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        
        return contact;
    }
    
    /** {@inheritDoc} */
    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        
        boolean isContact = command instanceof IContact;
        
        System.out.println("Is contact? " + isContact);
        
        if (isContact) {
            
            IContact contact = (IContact)command;
            
            System.out.println("FirstName: " + contact.getName().getFirstName());
            System.out.println("LastName: " + contact.getName().getLastName());
        }
        
        System.out.println("redirecting to success.");
        return new ModelAndView(new RedirectView(getSuccessView()));
    }
}
