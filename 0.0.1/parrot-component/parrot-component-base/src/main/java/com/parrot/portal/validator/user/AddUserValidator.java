package com.parrot.portal.validator.user;

import org.springframework.validation.Errors;

import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.validator.AbstractValidator;
import com.parrot.portal.validator.NameValidator;


/**
 * @author tajzivit
 */
public class AddUserValidator extends AbstractValidator {
    
    private NameValidator nameValidator;
    
    /**
     * @param nameValidator
     *                the nameValidator to set
     */
    public void setNameValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return IUser.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        IUser user = (IUser)obj;
        
        nameValidator.validate(user.getContact().getName(), errors);
    }
}
