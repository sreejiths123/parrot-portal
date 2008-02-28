package com.parrot.portal.validator;

import org.springframework.validation.Errors;

import com.parrot.portal.domain.core.ICountry;


/**
 * @author tajzivit
 */
public class CountryValidator extends AbstractValidator {
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return ICountry.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        ICountry country = (ICountry)obj;
        
        if (isEmpty(country.getCode())) {
            
            errors.reject("parrot.portal.error.validate.country.code.empty", "Country Code Cannot Be Empty.");
        }
        
        if (isEmpty(country.getName())) {
            
            errors.reject("parrot.portal.error.validate.country.name.empty", "Country Name Cannot Be Empty.");
        }
    }
}
