package com.parrot.portal.validator;

import org.springframework.validation.Errors;

import com.parrot.portal.domain.core.IName;


/**
 * @author tajzivit
 */
public class NameValidator extends AbstractValidator {
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return IName.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        IName name = (IName)obj;
        
        if (isEmpty(name.getFirstName())) {
            
            errors.reject("parrot.portal.error.validation.name.first.empty", "First Name Cannot be empty");
        }
        
        if (isEmpty(name.getLastName())) {
            errors.reject("parrot.portal.error.validation.name.last.empty", "Last Name Cannot be empty");
        }
    }
}
