package com.parrot.portal.domain.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.IName;
import com.parrot.portal.domain.core.ITelephone;
import com.parrot.portal.domain.core.impl.Contact;
import com.parrot.portal.domain.core.impl.Name;
import com.parrot.portal.domain.core.impl.Telephone;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.dao.IUserDao;
import com.parrot.portal.domain.user.impl.User;

/**
 * @author Petr
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class UserDaoIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private IUserDao dao;
	
	
	@Autowired
	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	@Test
	@Rollback(true)
	public void testCreate() {
		
		IUser user = new User();
		IName name = new Name();
		name.setFirstName("TEST");
		name.setLastName("NAME");
		IContact contact = new Contact();
		contact.setName(name);
		
		ITelephone tel = new Telephone();
		tel.setCountryPrefix("+420");
		tel.setLocalNumber("603");
		tel.setNumber("582433");
		
		contact.setTelephone(tel);		
		user.setContact(contact);
		
		dao.create(user);
		
		assertTrue(user.getId() > 0);
		
	}

	@Test
	@Rollback(true)
	public void testRead() {
		IUser user = new User();
		IName name = new Name();
		name.setFirstName("TEST");
		name.setLastName("NAME");
		IContact contact = new Contact();
		contact.setName(name);
		
		ITelephone tel = new Telephone();
		tel.setCountryPrefix("+420");
		tel.setLocalNumber("603");
		tel.setNumber("582433");
		
		contact.setTelephone(tel);		
		user.setContact(contact);
		
		dao.create(user);
		
		assertTrue(user.getId() > 0);
		
		IUser user2 = dao.read(user.getId());
		
		assertNotNull(user2);
		
	}

	@Test
	@Rollback(true)
	public void testUpdate() {
		IUser user = new User();
		IName name = new Name();
		name.setFirstName("TEST");
		name.setLastName("NAME");
		IContact contact = new Contact();
		contact.setName(name);
		
		ITelephone tel = new Telephone();
		tel.setCountryPrefix("+420");
		tel.setLocalNumber("603");
		tel.setNumber("582433");
		
		contact.setTelephone(tel);		
		user.setContact(contact);
		
		dao.create(user);
				
		IUser user2 = dao.read(user.getId());
		
		user2.getContact().getName().setFirstName("New name");
		
		IUser user3 = dao.read(user.getId());
		
		assertEquals("New name", user2.getContact().getName().getFirstName());
	}

	@Test
	@Rollback(true)
	public void testDelete() {
		IUser user = new User();
		IName name = new Name();
		name.setFirstName("TEST");
		name.setLastName("NAME");
		IContact contact = new Contact();
		contact.setName(name);
		
		ITelephone tel = new Telephone();
		tel.setCountryPrefix("+420");
		tel.setLocalNumber("603");
		tel.setNumber("582433");
		
		contact.setTelephone(tel);		
		user.setContact(contact);
		
		dao.create(user);
		
		dao.delete(user);
		
		IUser readUser = dao.read(user.getId());
		
		assertNull(readUser);
	}
	
	
}
