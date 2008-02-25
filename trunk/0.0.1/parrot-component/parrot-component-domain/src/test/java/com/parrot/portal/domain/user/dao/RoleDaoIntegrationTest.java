package com.parrot.portal.domain.user.dao;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.impl.Role;


/**
 * @author Petr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class RoleDaoIntegrationTest {
    
    private IRoleDao roleDao;
    
    

    @Autowired
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    @Test
    public void testCreate() {
        IRole role = new Role();
        role.setName("test Role");
        
        roleDao.create(role);
        
        assertTrue(role.getId() > 0);
    }
    
    @Test
    public void testDelete() {
        IRole role = new Role();
        role.setName("test Role");
        
        roleDao.create(role);
        assertTrue(role.getId() > 0);
        
        List<IRole> roles = roleDao.list();
        
        assertTrue(roles.size() == 1);
        
        roleDao.delete(role);
        
        roles = roleDao.list();
        
        assertTrue(roles.size() == 0);
        
        IRole roleRead = roleDao.read(role.getId());
        assertNull(roleRead);
    }
    
    @Test
    public void testList() {
        
        IRole role = new Role();
        role.setName("test Role");
        
        roleDao.create(role);
        assertTrue(role.getId() > 0);
        
        List<IRole> result = roleDao.list();
        
        assertTrue(result.size() == 1);
        assertEquals(role, result.get(0));
    }
    
    @Test
    public void testRead() {
        IRole role = new Role();
        role.setName("test Role");
        
        roleDao.create(role);
        
        IRole roleRead = roleDao.read(role.getId());
        assertNotNull(roleRead);
    }
    
    @Test
    public void testUpdate() {
        IRole role = new Role();
        role.setName("test Role");
        
        roleDao.create(role);
        
        IRole roleRead = roleDao.read(role.getId());
        
        roleRead.setName("changed name");
        
        roleDao.update(roleRead);
        
        IRole roleReRead = roleDao.read(roleRead.getId());
        
        assertEquals("changed name", roleReRead.getName());
    }
    
}
