package com.parrot.portal.rs.controller.secure;

import javax.servlet.http.HttpServletRequest;

import com.parrot.portal.controller.secure.AbstractModifyController;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.rs.command.impl.ModifyCategoryCommand;
import com.parrot.portal.rs.domain.ICategory;
import com.parrot.portal.rs.service.impl.RsService;


/**
 * @author tajzivit
 */
public class ModifyCategoryController extends AbstractModifyController<ICategory> {
    
    private IDomainFactory domainFactory;
    private RsService service;
    
    /** {@inheritDoc} */
    @Override
    public void doRemove(ICategory arg0) {
        service.delete(arg0);
    }
    
    /** {@inheritDoc} */
    @Override
    public void doUpdate(ICategory arg0) {
        service.update(arg0);
    }
    
    /**
     * @param domainFactory
     *                the domainFactory to set
     */
    public void setDomainFactory(IDomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }
    
    /**
     * @param service
     *                the service to set
     */
    public void setService(RsService service) {
        this.service = service;
    }
    
    /** {@inheritDoc} */
    @Override
    protected Object getCommand(HttpServletRequest request) throws Exception {
        return new ModifyCategoryCommand(domainFactory);
    }
}
