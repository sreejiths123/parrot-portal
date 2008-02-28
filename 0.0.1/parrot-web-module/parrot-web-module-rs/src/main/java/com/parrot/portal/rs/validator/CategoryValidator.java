package com.parrot.portal.rs.validator;

import org.springframework.validation.Errors;

import com.parrot.portal.rs.domain.ICategory;
import com.parrot.portal.validator.AbstractValidator;


/**
 * @author tajzivit
 */
public class CategoryValidator extends AbstractValidator {
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return ICategory.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object arg0, Errors arg1) {
        
    }
}
