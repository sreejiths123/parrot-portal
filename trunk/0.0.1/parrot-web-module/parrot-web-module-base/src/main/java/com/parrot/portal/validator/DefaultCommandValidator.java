package com.parrot.portal.validator;

import org.springframework.validation.Errors;

import com.parrot.portal.controller.command.IParrotCommand;


/**
 * @author tajzivit
 */
public class DefaultCommandValidator extends AbstractValidator {
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return IParrotCommand.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public void validate(Object obj, Errors errors) {
        
        IParrotCommand command = (IParrotCommand)obj;
        
        if (isEmpty(command)) {
            errors.reject("parrot.portal.error.validate.command.empty", "Error has occured. Please call the helpdesk");
        }
    }
}
