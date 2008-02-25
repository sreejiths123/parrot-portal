/**
 * 
 */
package com.parrot.portal.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parrot.portal.domain.user.IModule;
import com.parrot.portal.domain.user.IRole;
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
    public IModule insertModule(IModule module) {
        
        moduleDao.create(module);
        
        return module;
    }
    
    /** {@inheritDoc} */
    public IRole insertRole(IRole role) {
        
        roleDao.create(role);
        
        return role;
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
    
    
    /** {@inheritDoc} */
    public List<IModule> listModule() {
        return moduleDao.list();
    }
    
    
    /** {@inheritDoc} */
    public List<IRole> listRole() {
        return roleDao.list();
    }
    
    /** {@inheritDoc} */
    public void remove(IRole role) {
        roleDao.delete(role);
    }
    
    /** {@inheritDoc} */
    public void remove(IUser user) {
        userDao.delete(user);
    }
    
    public void setModuleDao(IModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }
    
    public void setRoleDao(IRoleDao roleDao) {
        this.roleDao = roleDao;
    }
    
    public void setTaskDao(ITaskDao taskDao) {
        this.taskDao = taskDao;
    }
    
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
    
    /** {@inheritDoc} */
    public void update(IRole role) {
        roleDao.update(role);
    }
    
    /** {@inheritDoc} */
    public void update(IUser user) {
        userDao.update(user);
    }
}
