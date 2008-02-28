package com.parrot.portal.rs.command.impl;

import com.parrot.portal.controller.command.impl.AbstractParrotCommand;
import com.parrot.portal.domain.factory.IDomainFactory;
import com.parrot.portal.rs.command.IModifyCategoryCommand;
import com.parrot.portal.rs.domain.ICategory;


/**
 * @author tajzivit
 */
public class ModifyCategoryCommand extends AbstractParrotCommand<ICategory> implements IModifyCategoryCommand {
    
    public ModifyCategoryCommand(IDomainFactory domainFactory) {
        setObject(domainFactory.getDomainObject(ICategory.class));
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
