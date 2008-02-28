package com.parrot.portal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author tajzivit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml", "/WEB-INF/base-user-servlet.xml" })
public class StartApplicationContextTest {
    
    @Test
    public void startApllicationContext() {
        
    }
}
