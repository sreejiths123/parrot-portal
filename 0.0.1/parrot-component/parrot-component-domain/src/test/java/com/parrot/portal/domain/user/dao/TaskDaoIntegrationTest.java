/**
 * 
 */
package com.parrot.portal.domain.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.parrot.portal.domain.user.IModule;
import com.parrot.portal.domain.user.ITask;
import com.parrot.portal.domain.user.impl.Module;
import com.parrot.portal.domain.user.impl.Task;

/**
 * @author Petr
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class TaskDaoIntegrationTest {

	private ITaskDao taskDao;

	@Autowired
	public void setTaskDao(ITaskDao taskDao) {
		this.taskDao = taskDao;
	}

	/**
	 * Test method for
	 * {@link com.parrot.portal.domain.dao.GenericDao#create(java.lang.Object)}.
	 */
	@Test
	public void testCreate() {
		ITask task = new Task();
		task.setQualifiedName("test.package.ClassName");

		IModule module = new Module();
		module.setName("Module Name");

		task.setModule(module);

		taskDao.create(task);

		assertTrue(task.getId() > 0);

		// now test cascading
		assertTrue(module.getId() > 0);
	}

	/**
	 * Test method for
	 * {@link com.parrot.portal.domain.dao.GenericDao#read(java.io.Serializable)}.
	 */
	@Test
	public void testRead() {
		ITask task = new Task();
		task.setQualifiedName("test.package.ClassName");	

		taskDao.create(task);
		
		ITask taskRead = taskDao.read(task.getId());
		
		assertNotNull(taskRead);
	}

	/**
	 * Test method for
	 * {@link com.parrot.portal.domain.dao.GenericDao#update(java.lang.Object)}.
	 */
	@Test
	@Ignore("Not yet ready")
	public void testUpdate() {
		ITask task = new Task();
		task.setQualifiedName("test.package.ClassName");	

		taskDao.create(task);
		
		ITask taskRead = taskDao.read(task.getId());
		
		assertNotNull(taskRead);
	}

	/**
	 * Test method for
	 * {@link com.parrot.portal.domain.dao.GenericDao#delete(java.lang.Object)}.
	 */
	@Test
	public void testDelete() {
		ITask task = new Task();
		task.setQualifiedName("test.package.ClassName");	

		taskDao.create(task);
		
		ITask taskRead = taskDao.read(task.getId());
		
		assertNotNull(taskRead);
		
		taskDao.delete(taskRead);
		
		assertNull(taskDao.read(taskRead.getId()));
	}
	
	@Test
	public void testFindByModuleId(){
		ITask task = new Task();
		task.setQualifiedName("test.package.ClassName");

		IModule module = new Module();
		module.setName("Module Name");

		task.setModule(module);

		taskDao.create(task);

		int id = module.getId();
		
		List<ITask> foundTasks = taskDao.findByModuleId(id);
		
		assertEquals(task.getQualifiedName(), foundTasks.get(0).getQualifiedName());
	}	

}
