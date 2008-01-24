package com.parrot.portal.domain.user;

import java.util.Set;

import com.parrot.portal.domain.core.IContact;
import com.parrot.portal.domain.core.IPersistentObject;

/**
 * @author macekpet
 */
public interface IUser extends IPersistentObject<Integer> {

	/**
	 * @return information about current user
	 */
	IContact getContact();

	/**
	 * @param contact
	 *            information about current user
	 */
	void setContact(IContact contact);

	/**
	 * Gets the list of roles in which the user is.
	 * @return user's roles
	 */
	Set<IRole> getRoles();

	/**
	 * Adds role
	 * @param role role to add
	 */
	void addRole(IRole role);

}
