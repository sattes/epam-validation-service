package com.epam.validation.service.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.validation.service.constants.EpamConstants;
import com.epam.validation.service.response.ValidatorResponse;
import com.epam.validation.service.response.ValidatorResponseUtil;

/**
 * Validator class to check the min length and max length
 * @author sattes
 *
 */
@Service
public class LengthValidator {
	
	@Autowired
	ValidatorResponseUtil responseUtil;
	
	public ValidatorResponse validateLength(String password) {
		
		ValidatorResponse response = null;
		if(password.length() < 5) {
			response = responseUtil.getValidatorResponse(EpamConstants.ERROR_CODE_001, EpamConstants.ERROR_MESSAGE1_001, false);
		} else if(password.length() > 12) {
			response = responseUtil.getValidatorResponse(EpamConstants.ERROR_CODE_001, EpamConstants.ERROR_MESSAGE2_001, false);
		} else {
			response = responseUtil.getValidatorResponse(EpamConstants.SUCCESS_CODE_001, EpamConstants.SUCCESS_MESSAGE_001, true);
		}
		
		return response;
	}

}
