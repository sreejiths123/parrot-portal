/***************************************************************************************************
 * Copyright 2007 NetCom. All rights reserved.
 **************************************************************************************************/

package com.parrot.portal.domain.eshop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.parrot.portal.domain.eshop.IContact;


/**
 * @author tajzivit
 */
public class ContactValidator implements Validator {
    
    /** {@inheritDoc} */
    public boolean supports(Class arg0) {
        return IContact.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        if (!(obj instanceof IContact)) {
            errors.reject("Given object is not an instance of IContact.");
        }
        
        IContact contact = (IContact)obj;
        
        if (contact.getId() < 0) {
            errors.reject("ID cannot be negative");
        }
        
        if (contact.getName() == null) {
            errors.reject("Name must be set.");
        } else {
            if (isEmpty(contact.getName().getFirstName())) {
                errors.reject("First name cannot be empty.");
            }
            
            if (isEmpty(contact.getName().getLastName())) {
                errors.reject("Last name cannot be empty.");
            }
        }
    }
    
    private boolean isEmpty(String str) {
        
        return str == null || str.equals("");
    }
}
