package com.parrot.portal.domain.user.impl;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IModule;
import com.parrot.portal.domain.user.ITask;
import com.parrot.portal.domain.user.ITaskAccessRight;

public class Task extends BasicPersistentObject implements ITask {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9032301876886242235L;
	private IModule module;
	private String qualifiedName;
	private ITaskAccessRight right;

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

	public ITaskAccessRight getRight() {
		return right;
	}

	public void setRight(TaskAccessRight right) {
		this.right = right;
	}

}
