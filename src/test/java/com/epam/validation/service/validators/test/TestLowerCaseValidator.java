package com.epam.validation.service.validators.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.validation.service.response.ValidatorResponse;
import com.epam.validation.service.validators.LowerCaseValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:epam-validation-context.xml")
public class TestLowerCaseValidator {
	
	@Autowired
	LowerCaseValidator validator;
	
	@Before
	public void init() {
		
	}

	@Test
	public void testSuccessForLowerCase() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setResponseCode("SUCCESS-002");
		expectedResponse.setResponseMessage("Lower case letter validation is successful.");
		
		ValidatorResponse actualResponse = validator.validateLowerCaseLetters("subsub123");

		Assert.assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
		Assert.assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
		
	}
	
	@Test
	public void testFailureForLowerCase() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-002");
		expectedResponse.setErrorMessage("Password should contain atleast one lower case letter.");
		
		ValidatorResponse actualResponse = validator.validateLowerCaseLetters("SUBBU12");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}

}
