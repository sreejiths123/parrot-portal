/**
 * 
 */
package com.parrot.portal.domain.user.service;

import com.parrot.portal.domain.user.IUser;

/**
 * Facade interface to ease the user package objects manipulation. This should
 * be generally the main entry point to the underlying object manipulation and
 * should be used by the web modules.
 * 
 * @author macekpet
 * 
 */
public interface IUserManagementService {

	/**
	 * Creates new transient IUser object.
	 * 
	 * @return transient IUser instance
	 */
	IUser createUser();

	/**
	 * Makes the user object persistent. All linked objects are persisted too
	 * (if not already persistent).
	 * 
	 * @param user transient instance
	 * @return persistent IUser instance
	 */
	IUser insertUser(IUser user);

}
