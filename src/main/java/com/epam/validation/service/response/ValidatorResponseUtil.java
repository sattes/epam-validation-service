package com.epam.validation.service.response;

import org.springframework.stereotype.Service;

/**
 * Util class that will create the give the instance of the ValidatorResponse
 * @author sattes
 *
 */
@Service
public class ValidatorResponseUtil {
	
	public ValidatorResponse getValidatorResponse(String code, String message, boolean success) {
		ValidatorResponse response = new ValidatorResponse();
		if(success) {
			response.setResponseCode(code);
			response.setResponseMessage(message);
		} else {
			response.setErrorCode(code);
			response.setErrorMessage(message);
		}
		return response;
	}
	
}
