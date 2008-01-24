package com.parrot.portal.domain.user;

import java.util.Set;

import com.parrot.portal.domain.core.IPersistentObject;

/**
 * Role is representing user access right to certain components in the
 * application.
 * 
 * @author macekpet
 * 
 */
public interface IRole extends IPersistentObject<Integer> {

	/**
	 * Gets Role name
	 * 
	 * @return name
	 */
	String getName();

	/**
	 * Sets Role name
	 * 
	 * @param name
	 */
	void setName(String name);

	/**
	 * Gets set of users in this role. This set does not support addition and is read only.
	 * If you need to add connection, please do so on the User object.
	 * @return Set of users in the role.
	 */
	Set<IUser> getUsers();
	

}