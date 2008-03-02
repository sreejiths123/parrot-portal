package com.parrot.portal.rs.controller.secure;

import javax.servlet.http.HttpServletRequest;

import com.parrot.portal.controller.secure.AbstractModifyController;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.rs.command.impl.ModifyArticleCommand;
import com.parrot.portal.rs.domain.IArticle;
import com.parrot.portal.rs.service.IRsService;


/**
 * @author tajzivit
 */
public class ModifyArticleController extends AbstractModifyController<IArticle> {
    
    private IDomainFactory domainFactory;
    private IRsService service;
    
    
    /** {@inheritDoc} */
    @Override
    public void doRemove(IArticle arg0) {
        service.delete(arg0);
    }
    
    /** {@inheritDoc} */
    @Override
    public void doUpdate(IArticle arg0) {
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
    public void setService(IRsService service) {
        this.service = service;
    }
    
    /** {@inheritDoc} */
    @Override
    protected Object getCommand(HttpServletRequest request) throws Exception {
        return new ModifyArticleCommand(domainFactory);
    }
}
