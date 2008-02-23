package com.parrot.portal.validator;

import org.springframework.validation.Validator;


/**
 * @author tajzivit
 */
public abstract class AbstractValidator implements Validator {
    
    /**
     * @param <T>
     *                type of the object
     * @param value
     *                object to test
     * @return TRUE if object is empty
     */
    public <T> boolean isEmpty(T value) {
        
        if (value == null) {
            return true;
        }
        
        if (value instanceof String) {
            String s = (String)value;
            return s.trim().length() == 0;
        }
        
        return false;
    }
}
