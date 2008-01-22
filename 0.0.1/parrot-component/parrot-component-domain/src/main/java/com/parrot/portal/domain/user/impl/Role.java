package com.parrot.portal.domain.user.impl;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IRole;

public class Role extends BasicPersistentObject implements IRole {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8734971203599582474L;
	private String name;
	
	
	/* (non-Javadoc)
	 * @see com.parrot.portal.domain.core.impl.IRole#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.parrot.portal.domain.core.impl.IRole#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
