package com.epam.validation.service;

import org.springframework.stereotype.Service;

import com.epam.validation.service.response.ValidatorResponse;

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
	public ValidatorResponse validatePassword(String password);

}
