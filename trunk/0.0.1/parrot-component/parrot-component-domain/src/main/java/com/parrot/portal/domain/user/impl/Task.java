package com.parrot.portal.domain.user.impl;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IModule;
import com.parrot.portal.domain.user.ITask;

public class Task extends BasicPersistentObject implements ITask {

	private IModule module;
	private String qualifiedName;
	
	public IModule getModule() {
		return module;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	public void setModule(IModule module) {
		this.module = module;		
	}

	public void setQualifiedName(String name) {
		this.qualifiedName = name;
	}	

}
