package com.epam.validation.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.validation.service.PasswordValidator;
import com.epam.validation.service.response.ValidatorResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:epam-validation-context.xml")
public class TestPasswordValidator {
	
	@Autowired
	PasswordValidator validator;
	
	@Before
	public void init() {
		
	}

	@Test
	public void testSuccessPassword() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setResponseCode("SUCCESS");
		expectedResponse.setResponseMessage("All validations are passed.");
		
		ValidatorResponse actualResponse = validator.validatePassword("subbu1234");

		Assert.assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
		Assert.assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
		
	}
	
	@Test
	public void testNullPassword() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-000");
		expectedResponse.setErrorMessage("Password should not be null or empty.");
		
		ValidatorResponse actualResponse = validator.validatePassword(null);

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());
		
	}
	
	@Test
	public void testEmptyPassword() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-000");
		expectedResponse.setErrorMessage("Password should not be null or empty.");
		
		ValidatorResponse actualResponse = validator.validatePassword("");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());
		
	}
	
	@Test
	public void testFailureForMinLength() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-001");
		expectedResponse.setErrorMessage("Minimum length of the password should be 5 characters.");
		
		ValidatorResponse actualResponse = validator.validatePassword("sub1");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}
	
	@Test
	public void testFailureForMaxLength() {
		
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-001");
		expectedResponse.setErrorMessage("Maximum length of the password should be 12 characters.");
		
		ValidatorResponse actualResponse = validator.validatePassword("subbu12345678");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

	}
	
	@Test
	public void testFailureForLowerCase() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-002");
		expectedResponse.setErrorMessage("Password should contain atleast one lower case letter.");
		
		ValidatorResponse actualResponse = validator.validatePassword("SUBBU12");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}
	
	@Test
	public void testFailureForNumerics() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-003");
		expectedResponse.setErrorMessage("Password should contain atleast one numeric.");
		
		ValidatorResponse actualResponse = validator.validatePassword("subbusubbu");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}

}
