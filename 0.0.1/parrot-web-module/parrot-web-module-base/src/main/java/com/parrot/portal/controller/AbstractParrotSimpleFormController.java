package com.parrot.portal.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;

import com.parrot.portal.domain.factory.IDomainFactory;


/**
 * @author tajzivit
 */
public abstract class AbstractParrotSimpleFormController extends SimpleFormController {
    
    private IDomainFactory domainFactory;
    
    
    public IDomainFactory getDomainFactory() {
        return domainFactory;
    }
    
    
    public void setDomainFactory(IDomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }
}
