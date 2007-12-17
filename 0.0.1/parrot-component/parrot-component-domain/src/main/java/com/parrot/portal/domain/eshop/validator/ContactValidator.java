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
            errors.reject("com.parrot.portal.error.given_object_is_not_correct_one");
        }
        
        IContact contact = (IContact)obj;
        
        if (contact.getId() < 0) {
            errors.rejectValue("id", "com.parrot.portal.error.contact.id_cannot_be_negative");
        }
        
        if (contact.getName() == null) {
            errors.rejectValue("name", "com.parrot.portal.error.contact.name.must_be_set");
        } else {
            if (isEmpty(contact.getName().getFirstName())) {
                errors.rejectValue("name.firstName", "com.parrot.portal.error.contact.name.first_name_cannot_be_empty");
            }
            
            if (isEmpty(contact.getName().getLastName())) {
                errors.rejectValue("name.lastName", "com.parrot.portal.error.contact.name.last_name_cannot_be_empty");
            }
        }
    }
    
    private boolean isEmpty(String str) {
        
        return str == null || str.equals("");
    }
}
