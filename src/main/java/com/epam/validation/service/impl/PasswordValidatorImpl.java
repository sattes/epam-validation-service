package com.epam.validation.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.epam.validation.service.PasswordValidator;

/**
 * Implementation class for validating the password
 * @author sattes
 *
 */
@Service
public class PasswordValidatorImpl implements PasswordValidator {

	
	private PasswordValidatorImpl() {
		// do nothing
	}

	/**
	 * @param password Password string
	 * @return Returns true if the password is valid or returns false if the password is not valid
	 */
	public boolean validatePassword(String password) {
		String pattern = null;
		
		//For Lower case letters
		StringBuilder patternBuilder = new StringBuilder("((?=.*^[a-z])");

		//For numbers
		patternBuilder.append("(?=.*[0-9])");
		
		int minLength = 5;
		int maxLength = 12;

		patternBuilder.append(".{" + minLength + "," + maxLength + "})");
		pattern = patternBuilder.toString();
		//pattern = "((?=.*[0-9])(?=.*^[a-z]).{5,12})";
		//pattern = "(^(?=.*[0-9])(?=.*^[a-z]).{5,12}(?:([\\w\\d*?!:;])\1?(?!\1))$)";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(password);
		boolean result = m.matches();
		System.out.println("result = "+result);
		
		return result;
	}
	
	

}
