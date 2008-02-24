package com.parrot.portal.domain.user.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author tajzivit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserManagementServiceIntegrationTest {
    
    private UserManagementService service;
    
    /**
     * @param service
     *                the service to set
     */
    public void setService(UserManagementService service) {
        this.service = service;
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.domain.user.service.impl.UserManagementService#createUser()}.
     */
    @Test
    public void testCreateUser() {
        fail("Not yet implemented");
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.domain.user.service.impl.UserManagementService#insertUser(com.parrot.portal.domain.user.IUser)}.
     */
    @Test
    public void testInsertUser() {
        fail("Not yet implemented");
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.domain.user.service.impl.UserManagementService#list()}.
     */
    @Test
    public void testList() {
        fail("Not yet implemented");
    }
    
}
