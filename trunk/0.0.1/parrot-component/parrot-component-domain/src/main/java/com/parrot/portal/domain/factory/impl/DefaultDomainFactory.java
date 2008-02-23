package com.parrot.portal.domain.factory.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.exception.ErrorType;
import com.parrot.portal.exception.TechnicalErrorException;


/**
 * @author tajzivit
 */
public class DefaultDomainFactory implements IDomainFactory, ApplicationContextAware {
    
    /**
     * name of the bean for this factory
     */
    public static String BEAN_NAME = "defaultDomainFactory";
    
    private ApplicationContext context;
    
    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    public <T> T getDomainObject(Class<T> objetcsClass) {
        
        String[] beanNames = context.getBeanNamesForType(objetcsClass);
        
        if (beanNames.length != 1) {
            throw new TechnicalErrorException(ErrorType.BEAN_ERROR);
        }
        
        return (T)context.getBean(beanNames[0]);
    }
    
    /** {@inheritDoc} */
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }
}
