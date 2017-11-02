package com.epam.validation.service.constants;

public final class EpamConstants {
	
	private EpamConstants() {
		
	}
	
	public static final String SUCCESS_CODE = "SUCCESS";
	public static final String SUCCESS_MESSAGE = "All validations are passed.";
	
	public static final String ERROR_CODE = "E-000";
	public static final String ERROR_MESSAGE = "Password should not be null or empty.";
	
	public static final String SUCCESS_CODE_003 = "SUCCESS-003";
	public static final String SUCCESS_MESSAGE_003 = "Numeric validation is successful.";
	
	public static final String ERROR_CODE_003 = "E-003";
	public static final String ERROR_MESSAGE_003 = "Password should contain atleast one numeric.";
	
	public static final String SUCCESS_CODE_002 = "SUCCESS-002";
	public static final String SUCCESS_MESSAGE_002 = "Lower case letter validation is successful.";
	
	public static final String ERROR_CODE_002 = "E-002";
	public static final String ERROR_MESSAGE_002 = "Password should contain atleast one lower case letter.";
	
	public static final String SUCCESS_CODE_001 = "SUCCESS-001";
	public static final String SUCCESS_MESSAGE_001 = "Length validation is successs";
	
	public static final String ERROR_CODE_001 = "E-001";
	public static final String ERROR_MESSAGE1_001 = "Minimum length of the password should be 5 characters.";
	public static final String ERROR_MESSAGE2_001 = "Maximum length of the password should be 12 characters.";
	
	
}
