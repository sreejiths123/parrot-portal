package com.parrot.portal.controller.command.user.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author tajzivit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml", "/WEB-INF/base-user-servlet.xml" })
public class ModifyRoleCommandTest {
    
    @Autowired
    private ModifyRoleCommand command;
    
    /**
     * @param command
     *                the command to set
     */
    public void setCommand(ModifyRoleCommand command) {
        this.command = command;
    }
    
    /**
     * Test method for
     * {@link com.parrot.portal.controller.command.user.impl.AbstractParrotCommand#getObject()}.
     */
    @Test
    public void testGetCommand() {
        assertNotNull(command);
        assertNotNull(command.getObject());
    }
}
