package com.parrot.portal.domain.user.impl;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IModule;

/**
 * @author macekpet
 */
public class Module extends BasicPersistentObject implements IModule {

	private String name;

	/** {@inheritDoc} */
	public String getName() {
		return name;
	}

	/** {@inheritDoc} */
	public void setName(String name) {
		this.name = name;
	}

}
