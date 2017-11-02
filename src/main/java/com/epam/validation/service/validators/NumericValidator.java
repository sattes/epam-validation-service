package com.epam.validation.service.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.validation.service.constants.EpamConstants;
import com.epam.validation.service.response.ValidatorResponse;
import com.epam.validation.service.response.ValidatorResponseUtil;

/**
 * Validator class to check for numerics
 * @author sattes
 *
 */
@Service
public class NumericValidator {
	
	@Autowired
	ValidatorResponseUtil responseUtil;
	
	public ValidatorResponse validateNumerics(String password) {
		String lowerCasePattern = ".*[0-9].*";
		
		Pattern p = Pattern.compile(lowerCasePattern);
		Matcher m = p.matcher(password);
		
		boolean result = m.matches();
		
		
		if(result) {
			return responseUtil.getValidatorResponse(EpamConstants.SUCCESS_CODE_003, EpamConstants.SUCCESS_MESSAGE_003, true);
		} else {
			return responseUtil.getValidatorResponse(EpamConstants.ERROR_CODE_003, EpamConstants.ERROR_MESSAGE_003, false);
		}
		
	}

}
