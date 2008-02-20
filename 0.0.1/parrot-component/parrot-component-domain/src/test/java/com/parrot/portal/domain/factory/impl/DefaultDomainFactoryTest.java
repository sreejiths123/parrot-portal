package com.parrot.portal.domain.factory.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.exception.ErrorType;
import com.parrot.portal.exception.TechnicalErrorException;


/**
 * @author tajzivit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class DefaultDomainFactoryTest {
    
    @Autowired
    private DefaultDomainFactory factory;
    
    /**
     * @param factory
     *                the factory to set
     */
    public void setFactory(DefaultDomainFactory factory) {
        this.factory = factory;
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.domain.factory.impl.DefaultDomainFactory#getDomainObject(java.lang.Class)}.
     */
    @Test
    public void testGetDomainObject() {
        
        assertNotNull(factory);
        
        IUser user = factory.getDomainObject(IUser.class);
        assertNotNull(user);
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.domain.factory.impl.DefaultDomainFactory#getDomainObject(java.lang.Class)}.
     */
    @Test(expected = TechnicalErrorException.class)
    public void testGetDomainObjectFails() {
        
        assertNotNull(factory);
        
        try {
            
            factory.getDomainObject(SomeNotDefinedClass.class);
            
        } catch (TechnicalErrorException e) {
            
            assertEquals(ErrorType.BEAN_ERROR, e.getErrorType());
            
            throw e;
        }
    }
    
    private class SomeNotDefinedClass {
        
    }
}
