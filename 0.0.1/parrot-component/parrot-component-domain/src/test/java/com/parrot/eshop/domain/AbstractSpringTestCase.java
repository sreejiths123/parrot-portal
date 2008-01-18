package com.parrot.eshop.domain;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;


/**
 * @author macekpet
 *
 */
public abstract class AbstractSpringTestCase extends AbstractTransactionalDataSourceSpringContextTests {

    @Override
    protected String[] getConfigLocations() {
        System.out.println("loading Context");
        return new String[] { "applicationContext.xml" };
    }    
    
    
}
