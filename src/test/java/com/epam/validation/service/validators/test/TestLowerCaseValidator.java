package com.epam.validation.service.validators.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.validation.service.constants.EpamConstants;
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
		expectedResponse.setResponseCode(EpamConstants.SUCCESS_CODE_002);
		expectedResponse.setResponseMessage(EpamConstants.SUCCESS_MESSAGE_002);
		
		ValidatorResponse actualResponse = validator.validateLowerCaseLetters("subsub123");

		Assert.assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
		Assert.assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
		
	}
	
	@Test
	public void testFailureForLowerCase() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode(EpamConstants.ERROR_CODE_002);
		expectedResponse.setErrorMessage(EpamConstants.ERROR_MESSAGE_002);
		
		ValidatorResponse actualResponse = validator.validateLowerCaseLetters("SUBBU12");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}

}
