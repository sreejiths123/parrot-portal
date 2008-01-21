package com.parrot.portal.domain.news.dao.impl;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.parrot.portal.domain.news.INews;
import com.parrot.portal.domain.news.impl.News;

public class NewsDaoTest {
	
	private ApplicationContext ctx;
	
	 public NewsDaoTest()
	    {
	        ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
	    }
	
	@Before
	public void setUp() throws Exception
    {
        openSession();
    }

	@After
    public void tearDown() throws Exception
    {
        closeSession();
    }

	@Test
	public void testCreate() {
		// Create
        NewsDao newsDao = getNewsDao();
        INews news = new News();
        news.setHeadline("Headline");
        newsDao.create(news);
        assertNotNull(news.getId());
        assertTrue(news.getId() > 0);
        assertTrue(news instanceof INews);

       
	}
	
	@Test
	public void testFindByheadline() {
		NewsDao newsDao = getNewsDao();
        News news = new News();
        news.setHeadline("Headline lookup test");
        newsDao.create(news);
        restartSession();
        
        List<INews> newsLookedUp = newsDao.findByHeadline("Headline lookup test");
        assertTrue(newsLookedUp.size() > 0);
        assertEquals(news.getId(), newsLookedUp.get(0).getId());
        restartSession();
        
        newsDao.delete(news);
	}

	@Test
	public void testRead() {
		NewsDao newsDao = getNewsDao();
        News news = new News();
        news.setHeadline("Headline lookup test");
        newsDao.create(news);
        restartSession();
        
        INews newsLookedUp = newsDao.read(news.getId());
        assertEquals(news.getId(), newsLookedUp.getId());
        restartSession();
        
        newsDao.delete(news);
        
	}

	@Test
	public void testUpdate() {
		NewsDao newsDao = getNewsDao();
        News news = new News();
        news.setHeadline("Update news test");
        newsDao.create(news);
        restartSession();
        
        INews newsLookedUp = newsDao.read(news.getId());
        assertEquals(news.getId(), newsLookedUp.getId());
        newsLookedUp.setHeadline("new headline");
        newsDao.update(newsLookedUp);
        restartSession();
                
        INews newsLookedUp2 = newsDao.read(newsLookedUp.getId());
        assertEquals(newsLookedUp.getId(), newsLookedUp.getId());
        assertEquals("new headline", newsLookedUp2.getHeadline());
        
        newsDao.delete(newsLookedUp2);
	}
	
	
	private void openSession()
    {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = SessionFactoryUtils.getSession(sessionFactory, true);
        TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
    }

    private void closeSession()
    {
        SessionFactory sessionFactory = getSessionFactory();
        SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager.unbindResource(sessionFactory);
        sessionHolder.getSession().flush();
        sessionHolder.getSession().close();
        SessionFactoryUtils.releaseSession(sessionHolder.getSession(), sessionFactory);
    }

    private void restartSession()
    {
        closeSession();
        openSession();
    }

    private SessionFactory getSessionFactory()
    {
        return (SessionFactory) ctx.getBean("sessionFactory");
    }
    
    private NewsDao getNewsDao(){
    	return (NewsDao)ctx.getBean("newsDao");
    }

}
