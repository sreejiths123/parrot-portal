package com.parrot.portal.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.parrot.portal.domain.user.IRole;


/**
 * @author tajzivit
 */
public class RoleValidator extends AbstractValidator implements Validator {
    
    /** {@inheritDoc} */
    public boolean supports(Class arg0) {
        return IRole.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        IRole role = (IRole)obj;
        
        if (isEmpty(role.getName())) {
            errors.reject("parrot.portal.error.validate.role.name.empty", "Name of Role Cannot Be Empty.");
        }
    }
}
