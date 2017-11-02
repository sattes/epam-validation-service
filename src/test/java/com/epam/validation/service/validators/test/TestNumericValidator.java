package com.epam.validation.service.validators.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.validation.service.response.ValidatorResponse;
import com.epam.validation.service.validators.NumericValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:epam-validation-context.xml")
public class TestNumericValidator {
	
	@Autowired
	NumericValidator validator;
	
	@Before
	public void init() {
		
	}

	@Test
	public void testSuccessForNumerics() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setResponseCode("SUCCESS-003");
		expectedResponse.setResponseMessage("Numeric validation is successful.");
		
		ValidatorResponse actualResponse = validator.validateNumerics("subsub123");

		Assert.assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
		Assert.assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
		
	}
	
	@Test
	public void testFailureForNumerics() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode("E-003");
		expectedResponse.setErrorMessage("Password should contain atleast one numeric.");
		
		ValidatorResponse actualResponse = validator.validateNumerics("subbusubbu");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}

}
