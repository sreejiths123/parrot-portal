/**
 * 
 */
package com.parrot.portal.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.dao.IModuleDao;
import com.parrot.portal.domain.user.dao.IRoleDao;
import com.parrot.portal.domain.user.dao.ITaskDao;
import com.parrot.portal.domain.user.dao.IUserDao;
import com.parrot.portal.domain.user.service.IUserManagementService;

/**
 * @author macekpet
 * 
 */
public class UserManagementService implements IUserManagementService {

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private ITaskDao taskDao;
	
	@Autowired
	private IModuleDao moduleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.parrot.portal.domain.user.service.IUserManagementService#createUser()
	 */
	public IUser createUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.parrot.portal.domain.user.service.IUserManagementService#insertUser(com.parrot.portal.domain.user.IUser)
	 */
	public IUser insertUser(IUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
