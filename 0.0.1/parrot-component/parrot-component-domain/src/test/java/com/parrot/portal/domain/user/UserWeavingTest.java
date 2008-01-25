package com.parrot.portal.domain.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.parrot.portal.domain.user.impl.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
public class UserWeavingTest {

	@Test
	@Ignore
	public void testWeaving(){
		User user = new User();
		
		assertNotNull(user.getContact());
		assertNotNull(user.getContact().getAddress());
		assertNotNull(user.getContact().getName());
		assertNotNull(user.getContact().getTelephone());		
	}
	
	
	
}
