package com.parrot.portal.domain.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parrot.portal.domain.user.impl.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class UserWeavingTest {
    
    @Autowired
    private User user;
    
    
    /**
     * @param user
     *                the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    @Test
    public void testWeaving() {
        
        assertNotNull(user.getContact());
        assertNotNull(user.getContact().getAddress());
        assertNotNull(user.getContact().getName());
        assertNotNull(user.getContact().getTelephone());
    }
}
