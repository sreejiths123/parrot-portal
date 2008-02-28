package com.parrot.portal.validator;

import org.springframework.validation.Errors;

import com.parrot.portal.domain.core.IAddress;
import com.parrot.portal.domain.core.IUrbanAddress;


/**
 * @author tajzivit
 */
public class AddressValidator extends AbstractValidator {
    
    private CountryValidator countryValidator;
    
    /**
     * @param countryValidator
     *                the countryValidator to set
     */
    public void setCountryValidator(CountryValidator countryValidator) {
        this.countryValidator = countryValidator;
    }
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return IAddress.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        if (obj instanceof IUrbanAddress) {
            validateUrbanAddress((IUrbanAddress)obj, errors);
        } else {
            errors.reject("parrot.portal.error.validate.system_error_has_occured");
        }
    }
    
    private void validateUrbanAddress(IUrbanAddress address, Errors errors) {
        
        if (isEmpty(address.getStreetName())) {
            errors.reject("parrot.portal.error.validation.address.street_name.empty", "Street Name Cannot be Empty.");
        }
        
        countryValidator.validate(address.getCountry(), errors);
    }
}
