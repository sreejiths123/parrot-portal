package com.parrot.portal.validator;

import org.springframework.validation.Errors;

import com.parrot.portal.domain.core.IContact;


/**
 * @author tajzivit
 */
public class ContactValidator extends AbstractValidator {
    
    private AddressValidator addressValidator;
    private NameValidator nameValidator;
    private TelephoneValidator telephoneValidator;
    
    
    /**
     * @param addressValidator
     *                the addressValidator to set
     */
    public void setAddressValidator(AddressValidator addressValidator) {
        this.addressValidator = addressValidator;
    }
    
    /**
     * @param nameValidator
     *                the nameValidator to set
     */
    public void setNameValidator(NameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }
    
    /**
     * @param telephoneValidator
     *                the telephoneValidator to set
     */
    public void setTelephoneValidator(TelephoneValidator telephoneValidator) {
        this.telephoneValidator = telephoneValidator;
    }
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public boolean supports(Class arg0) {
        return IContact.class.isAssignableFrom(arg0);
    }
    
    /** {@inheritDoc} */
    public void validate(Object obj, Errors errors) {
        
        IContact contact = (IContact)obj;
        
        addressValidator.validate(contact.getAddress(), errors);
        nameValidator.validate(contact.getName(), errors);
        telephoneValidator.validate(contact.getTelephone(), errors);
    }
}
