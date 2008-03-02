package com.parrot.portal.controller.test;

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
@ContextConfiguration(locations = "classpath:/applicationContextTest.xml")
public class TestControllerTest {
    
    @Autowired
    private TestController controller;
    
    /**
     * Test method for {@link com.parrot.portal.controller.test.TestController#handle()}.
     */
    @Test
    public void testHandle() {
        
        controller.handle();
    }
}
