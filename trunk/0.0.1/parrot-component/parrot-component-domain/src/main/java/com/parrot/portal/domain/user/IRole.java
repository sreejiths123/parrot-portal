package com.parrot.portal.domain.user;

import com.parrot.portal.domain.core.IPersistentObject;

/**
 * Role is representing user access right to certain components in the application.
 * @author macekpet
 *
 */
public interface IRole extends IPersistentObject<Integer> {

	/**
	 * Gets Role name
	 * @return name
	 */
	String getName();

	/**
	 * Sets Role name
	 * @param name
	 */
	void setName(String name);

}