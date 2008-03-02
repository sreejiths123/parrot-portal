package com.parrot.portal.rs.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author tajzivit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml", "/WEB-INF/parrot-portal-rs-servlet.xml" })
public class StartApplicationContextTest {
    
    
    @Test
    public void startApplicationContext() {
        
    }
}
