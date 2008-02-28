package com.parrot.portal.rs.domain.dao;

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
@ContextConfiguration(locations = { "classpath*:/applicationContext.xml" })
public class ArticleDaoIntegrationTest {
    
    @Autowired
    private IArticleDao articleDao;
    
    /**
     * Test method for {@link com.parrot.dao.GenericDao#create(java.lang.Object)}.
     */
    @Test
    public void testCreate() {
        fail("Not yet implemented");
    }
    
    /**
     * Test method for {@link com.parrot.dao.GenericDao#delete(java.lang.Object)}.
     */
    @Test
    public void testDelete() {
        fail("Not yet implemented");
    }
    
    /**
     * Test method for {@link com.parrot.dao.GenericDao#list()}.
     */
    @Test
    public void testList() {
        
        assertNotNull(articleDao);
        articleDao.list();
    }
    
    /**
     * Test method for {@link com.parrot.dao.GenericDao#read(java.io.Serializable)}.
     */
    @Test
    public void testRead() {
        fail("Not yet implemented");
    }
    
    /**
     * Test method for {@link com.parrot.dao.GenericDao#update(java.lang.Object)}.
     */
    @Test
    public void testUpdate() {
        fail("Not yet implemented");
    }
    
}
