package com.parrot.portal.validator;

import org.springframework.validation.Errors;

import com.parrot.portal.domain.core.ITelephone;


/**
 * @author tajzivit
 */
public class TelephoneValidator extends AbstractValidator {
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return ITelephone.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        ITelephone telephone = (ITelephone)obj;
        
        if (isEmpty(telephone.getCoutryPrefix())) {
            errors.reject("parrot.portal.error.validate.telephone.country_prefix.empty",
                          "Country Prefix Cannot Be Empty.");
        }
        
        if (isEmpty(telephone.getLocalNumber())) {
            errors.reject("parrot.portal.error.validate.telephone.local_number.empty", "Local Number Cannot Be Empty");
        }
    }
}
