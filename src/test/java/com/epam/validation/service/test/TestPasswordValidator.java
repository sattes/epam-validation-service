package com.epam.validation.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.validation.service.PasswordValidator;
import com.epam.validation.service.constants.EpamConstants;
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
		expectedResponse.setResponseCode(EpamConstants.SUCCESS_CODE);
		expectedResponse.setResponseMessage(EpamConstants.SUCCESS_MESSAGE);
		
		ValidatorResponse actualResponse = validator.validatePassword("subbu1234");

		Assert.assertEquals(expectedResponse.getResponseCode(), actualResponse.getResponseCode());
		Assert.assertEquals(expectedResponse.getResponseMessage(), actualResponse.getResponseMessage());
		
	}
	
	@Test
	public void testNullPassword() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode(EpamConstants.ERROR_CODE);
		expectedResponse.setErrorMessage(EpamConstants.ERROR_MESSAGE);
		
		ValidatorResponse actualResponse = validator.validatePassword(null);

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());
		
	}
	
	@Test
	public void testEmptyPassword() {
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode(EpamConstants.ERROR_CODE);
		expectedResponse.setErrorMessage(EpamConstants.ERROR_MESSAGE);
		
		ValidatorResponse actualResponse = validator.validatePassword("");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());
		
	}
	
	@Test
	public void testFailureForMinLength() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode(EpamConstants.ERROR_CODE_001);
		expectedResponse.setErrorMessage(EpamConstants.ERROR_MESSAGE1_001);
		
		ValidatorResponse actualResponse = validator.validatePassword("sub1");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}
	
	@Test
	public void testFailureForMaxLength() {
		
		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode(EpamConstants.ERROR_CODE_001);
		expectedResponse.setErrorMessage(EpamConstants.ERROR_MESSAGE2_001);
		
		ValidatorResponse actualResponse = validator.validatePassword("subbu12345678");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

	}
	
	@Test
	public void testFailureForLowerCase() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode(EpamConstants.ERROR_CODE_002);
		expectedResponse.setErrorMessage(EpamConstants.ERROR_MESSAGE_002);
		
		ValidatorResponse actualResponse = validator.validatePassword("SUBBU12");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}
	
	@Test
	public void testFailureForNumerics() {

		ValidatorResponse expectedResponse = new ValidatorResponse();
		expectedResponse.setErrorCode(EpamConstants.ERROR_CODE_003);
		expectedResponse.setErrorMessage(EpamConstants.ERROR_MESSAGE_003);
		
		ValidatorResponse actualResponse = validator.validatePassword("subbusubbu");

		Assert.assertEquals(expectedResponse.getErrorCode(), actualResponse.getErrorCode());
		Assert.assertEquals(expectedResponse.getErrorMessage(), actualResponse.getErrorMessage());

		
	}

}
