package com.epam.validation.service;

import org.springframework.stereotype.Service;

/**
 * Interface for validating the password
 * @author sattes
 *
 */
@Service
public interface PasswordValidator {

	/**
	 * 
	 * @param password Password string
	 * @return Returns true if the password is valid or returns false if the password is not valid
	 */
	public boolean validatePassword(String password);

}
