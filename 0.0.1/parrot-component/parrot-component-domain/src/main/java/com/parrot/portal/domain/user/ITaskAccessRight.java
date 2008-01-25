package com.parrot.portal.domain.user;

import java.util.Set;

import com.parrot.portal.domain.core.IPersistentObject;

public interface ITaskAccessRight extends IPersistentObject<Integer> {
	
	ITask getTask();
	
	void setTask(ITask task);
	
	Set<IRole> getRoles();
	
	void addRole(IRole role);
	
	
}
