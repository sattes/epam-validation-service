package com.epam.validation.service.response;

/**
 * Response domain class for the validatePassword service method
 * @author sattes
 *
 */
public class ValidatorResponse {
	
	private String responseCode;
	
	private String responseMessage;
	
	private String errorCode;
	
	private String errorMessage;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
