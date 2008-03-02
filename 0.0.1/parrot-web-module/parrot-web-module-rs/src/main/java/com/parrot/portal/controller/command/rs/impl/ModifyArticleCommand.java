package com.parrot.portal.controller.command.rs.impl;

import com.parrot.portal.controller.command.impl.AbstractParrotCommand;
import com.parrot.portal.controller.command.rs.IModifyArticleCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.domain.rs.IArticle;


/**
 * @author tajzivit
 */
public class ModifyArticleCommand extends AbstractParrotCommand<IArticle> implements IModifyArticleCommand {
    
    public ModifyArticleCommand(IDomainFactory domainFactory) {
        setObject(domainFactory.getDomainObject(IArticle.class));
    }
    
    /** {@inheritDoc} */
    public Integer getObjectsId() {
        return getObject().getId();
    }
    
    /** {@inheritDoc} */
    public void setObjectsId(Integer arg0) {
        getObject().setId(arg0);
    }
}
