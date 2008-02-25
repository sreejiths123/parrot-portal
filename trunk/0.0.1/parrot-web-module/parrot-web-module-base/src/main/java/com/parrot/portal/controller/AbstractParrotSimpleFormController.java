package com.parrot.portal.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;

import com.parrot.portal.domain.factory.IDomainFactory;


/**
 * @author tajzivit
 */
public abstract class AbstractParrotSimpleFormController extends SimpleFormController {
    
    private IDomainFactory domainFactory;
    
    
    /**
     * @return domain factory
     */
    public IDomainFactory getDomainFactory() {
        return domainFactory;
    }
    
    
    /**
     * @param domainFactory
     *                to be set
     */
    public void setDomainFactory(IDomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }
}
