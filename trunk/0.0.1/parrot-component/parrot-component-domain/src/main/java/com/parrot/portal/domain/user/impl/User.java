package com.parrot.portal.domain.user.impl;

import com.parrot.portal.domain.core.impl.BasicPersistentObject;
import com.parrot.portal.domain.user.IUser;


/**
 * @author tajzivit
 */
public class User extends BasicPersistentObject implements IUser {
    
    private String firstName;
    
  	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
   
}
