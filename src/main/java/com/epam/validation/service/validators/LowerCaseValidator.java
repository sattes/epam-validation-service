package com.epam.validation.service.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.validation.service.constants.EpamConstants;
import com.epam.validation.service.response.ValidatorResponse;
import com.epam.validation.service.response.ValidatorResponseUtil;

/**
 * Validator class to check for lower case letters
 * @author sattes
 *
 */
@Service
public class LowerCaseValidator {
	
	@Autowired
	ValidatorResponseUtil responseUtil;
	
	public ValidatorResponse validateLowerCaseLetters(String password) {
		String lowerCasePattern = ".*[a-z].*";
		
		Pattern p = Pattern.compile(lowerCasePattern);
		Matcher m = p.matcher(password);
		
		boolean result = m.matches();
		
		if(result) {
			return responseUtil.getValidatorResponse(EpamConstants.SUCCESS_CODE_002, EpamConstants.SUCCESS_MESSAGE_002, true);
		} else {
			return responseUtil.getValidatorResponse(EpamConstants.ERROR_CODE_002, EpamConstants.ERROR_MESSAGE_002, false);
		}
		
	}

}
