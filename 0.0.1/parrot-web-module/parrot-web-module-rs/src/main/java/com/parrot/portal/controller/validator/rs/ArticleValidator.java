package com.parrot.portal.controller.validator.rs;

import org.springframework.validation.Errors;

import com.parrot.portal.domain.rs.IArticle;
import com.parrot.portal.validator.AbstractValidator;


/**
 * @author tajzivit
 */
public class ArticleValidator extends AbstractValidator {
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return IArticle.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object arg0, Errors arg1) {
        
    }
}
