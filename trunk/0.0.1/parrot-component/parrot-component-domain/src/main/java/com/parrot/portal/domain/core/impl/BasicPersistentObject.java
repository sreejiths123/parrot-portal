package com.parrot.portal.domain.core.impl;

import com.parrot.portal.domain.core.IPersistentObject;

public abstract class BasicPersistentObject implements IPersistentObject<Integer> {

	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
