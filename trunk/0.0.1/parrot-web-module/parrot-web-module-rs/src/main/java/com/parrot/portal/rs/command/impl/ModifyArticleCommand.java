package com.parrot.portal.rs.command.impl;

import com.parrot.portal.controller.command.impl.AbstractParrotCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.rs.command.IModifyArticleCommand;
import com.parrot.portal.rs.domain.IArticle;


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
