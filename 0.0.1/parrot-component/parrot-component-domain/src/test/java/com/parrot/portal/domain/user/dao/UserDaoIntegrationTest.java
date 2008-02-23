package com.parrot.portal.domain.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.IName;
import com.parrot.portal.domain.core.ITelephone;
import com.parrot.portal.domain.core.impl.Contact;
import com.parrot.portal.domain.core.impl.Name;
import com.parrot.portal.domain.core.impl.Telephone;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.impl.Role;
import com.parrot.portal.domain.user.impl.User;

/**
 * @author Petr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserDaoIntegrationTest {
    
    @Autowired
    private IUser injectedUser;
    
    @Autowired
    private IRoleDao roleDao;
    
    @Autowired
    private IUserDao userDao;
    
    
    @Test
    public void testAddAndLinkRole() {
        
        IRole role = new Role();
        role.setName("Users role");
        
        roleDao.create(role);
        
        injectedUser.getContact().getName().setFirstName("Test");
        injectedUser.getContact().getName().setLastName("Lastname");
        
        injectedUser.addRole(role);
        
        userDao.create(injectedUser);
        
        assertTrue(role.getId() > 0);
        
        IUser user2 = userDao.read(injectedUser.getId());
        
        assertNotNull(user2);
        assertTrue(user2.getRoles().size() == 1);
        


    }
    
    @Test
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
        
        userDao.create(user);
        
        assertTrue(user.getId() > 0);
        
    }
    
    @Test
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
        
        userDao.create(user);
        
        userDao.delete(user);
        
        IUser readUser = userDao.read(user.getId());
        
        assertNull(readUser);
    }
    
    @Test
    public void testList() {
        
        IUser user = new User();
        IName name = new Name();
        name.setFirstName("TEST2");
        name.setLastName("NAME");
        IContact contact = new Contact();
        contact.setName(name);
        
        ITelephone tel = new Telephone();
        tel.setCountryPrefix("+420");
        tel.setLocalNumber("603");
        tel.setNumber("582433");
        
        contact.setTelephone(tel);
        user.setContact(contact);
        
        userDao.create(user);
        
        assertTrue(user.getId() > 0);
        
        List<IUser> result = userDao.list();
        
        assertTrue(result.size() == 1);
        //    assertEquals(user, result.get(0));
    }
    
    @Test
    public void testRead() {
        
        IUser user = new User();
        IName name = new Name();
        name.setFirstName("TEST2");
        name.setLastName("NAME");
        IContact contact = new Contact();
        contact.setName(name);
        
        ITelephone tel = new Telephone();
        tel.setCountryPrefix("+420");
        tel.setLocalNumber("603");
        tel.setNumber("582433");
        
        contact.setTelephone(tel);
        user.setContact(contact);
        
        userDao.create(user);
        
        assertTrue(user.getId() > 0);
        
        IUser user2 = userDao.read(user.getId());
        
        assertNotNull(user2);
        
    }
    
    @Test
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
        
        userDao.create(user);
        
        IUser user2 = userDao.read(user.getId());
        
        user2.getContact().getName().setFirstName("New name");
        
        IUser user3 = userDao.read(user.getId());
        
        assertEquals("New name", user3.getContact().getName().getFirstName());
    }
    
}
