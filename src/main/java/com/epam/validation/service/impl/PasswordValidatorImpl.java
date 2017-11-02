package com.epam.validation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.validation.service.PasswordValidator;
import com.epam.validation.service.constants.EpamConstants;
import com.epam.validation.service.response.ValidatorResponse;
import com.epam.validation.service.response.ValidatorResponseUtil;
import com.epam.validation.service.validators.LengthValidator;
import com.epam.validation.service.validators.LowerCaseValidator;
import com.epam.validation.service.validators.NumericValidator;

/**
 * Implementation class for validating the password
 * @author sattes
 *
 */
@Service
public class PasswordValidatorImpl implements PasswordValidator {
	
	@Autowired
	ValidatorResponseUtil responseUtil;
	
	@Autowired
	LengthValidator lengthValidator;
	
	@Autowired
	LowerCaseValidator lowerCaseValidator;
	
	@Autowired
	NumericValidator numericValidator;

	
	private PasswordValidatorImpl() {
		// do nothing
	}

	/**
	 * @param password Password string
	 * @return Returns true if the password is valid or returns false if the password is not valid
	 */
	public ValidatorResponse validatePassword(String password) {
		
		if(password == null || password.equals("")) {
			return responseUtil.getValidatorResponse(EpamConstants.ERROR_CODE, EpamConstants.ERROR_MESSAGE, false);
		} else {
			ValidatorResponse lengthResponse = lengthValidator.validateLength(password);
			if(lengthResponse.getResponseCode() != null && lengthResponse.getResponseCode().startsWith(EpamConstants.SUCCESS_CODE)) {
				ValidatorResponse lowerCaseResponse = lowerCaseValidator.validateLowerCaseLetters(password);
				if(lowerCaseResponse.getResponseCode() != null && lowerCaseResponse.getResponseCode().startsWith(EpamConstants.SUCCESS_CODE)) {
					ValidatorResponse numericResponse = numericValidator.validateNumerics(password);
					if(numericResponse.getResponseCode() != null && numericResponse.getResponseCode().startsWith(EpamConstants.SUCCESS_CODE)) {
						return responseUtil.getValidatorResponse(EpamConstants.SUCCESS_CODE, EpamConstants.SUCCESS_MESSAGE, true);
					} else {
						return numericResponse;
					}
				} else {
					return lowerCaseResponse;
				}
			} else {
				return lengthResponse;
			}
		}
		
	}

}
