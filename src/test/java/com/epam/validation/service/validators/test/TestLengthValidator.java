package com.epam.validation.service.validators.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.validation.service.response.ValidatorResponse;
import com.epam.validation.service.validators.LengthValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:epam-validation-context.xml")
public class TestLengthValidator {
	
	@Autowired
	LengthValidator validator;
	
	@Before
	public void init() {
		
	}

	@Test
	public void testSuccessPasswordLength() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setResponseCode("SUCCESS-001");
		expectedResponse.setResponseMessage("Length validation is successs");
		
		ValidatorResponse actualResponse = validator.validateLength("subsub123");

		Assert.assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
		Assert.assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
		
	}
	
	@Test
	public void testFailureForMinLength() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-001");
		expectedResponse.setErrorMessage("Minimum length of the password should be 5 characters.");
		
		ValidatorResponse actualResponse = validator.validateLength("sub1");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}
	
	@Test
	public void testFailureForMaxLength() {
		
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-001");
		expectedResponse.setErrorMessage("Maximum length of the password should be 12 characters.");
		
		ValidatorResponse actualResponse = validator.validateLength("subbu12345678");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

	}

}
