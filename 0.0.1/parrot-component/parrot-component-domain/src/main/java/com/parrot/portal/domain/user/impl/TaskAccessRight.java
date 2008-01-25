/**
 * 
 */
package com.parrot.portal.domain.user.impl;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IRole;
import com.parrot.portal.domain.user.ITask;
import com.parrot.portal.domain.user.ITaskAccessRight;

/**
 * @author Petr
 * 
 */
public class TaskAccessRight extends BasicPersistentObject implements
		ITaskAccessRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8236151506964941554L;

	private Set<IRole> roles;

	private ITask task;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.parrot.portal.domain.user.ITaskAccessRight#addRole(com.parrot.portal.domain.user.IRole)
	 */
	public void addRole(IRole role) {
		if (roles == null) {
			roles = new LinkedHashSet<IRole>();
		}
		roles.add(role);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.parrot.portal.domain.user.ITaskAccessRight#getRoles()
	 */
	public Set<IRole> getRoles() {
		return Collections.unmodifiableSet(roles);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.parrot.portal.domain.user.ITaskAccessRight#getTask()
	 */
	public ITask getTask() {
		return task;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.parrot.portal.domain.user.ITaskAccessRight#setTask(com.parrot.portal.domain.user.ITask)
	 */
	public void setTask(ITask task) {
		this.task = task;
	}

}
