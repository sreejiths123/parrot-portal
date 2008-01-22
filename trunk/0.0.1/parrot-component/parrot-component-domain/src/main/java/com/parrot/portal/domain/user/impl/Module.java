package com.parrot.portal.domain.user.impl;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IModule;

/**
 * @author macekpet
 */
public class Module extends BasicPersistentObject implements IModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4202454524411213428L;
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
