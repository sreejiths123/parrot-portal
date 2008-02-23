/**
 * 
 */
package com.parrot.portal.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parrot.portal.domain.user.IUser;
import com.parrot.portal.domain.user.dao.IModuleDao;
import com.parrot.portal.domain.user.dao.IRoleDao;
import com.parrot.portal.domain.user.dao.ITaskDao;
import com.parrot.portal.domain.user.dao.IUserDao;
import com.parrot.portal.domain.user.service.IUserManagementService;

/**
 * @author macekpet
 */
public class UserManagementService implements IUserManagementService {
    
    @Autowired
    private IModuleDao moduleDao;
    
    @Autowired
    private IRoleDao roleDao;
    
    @Autowired
    private ITaskDao taskDao;
    
    @Autowired
    private IUserDao userDao;
    
    /** {@inheritDoc} */
    public IUser createUser() {
        return null;
    }
    
    /** {@inheritDoc} */
    public IUser insertUser(IUser user) {
        userDao.create(user);
        return user;
    }
    
    /** {@inheritDoc} */
    public List<IUser> list() {
        return userDao.list();
    }
}
