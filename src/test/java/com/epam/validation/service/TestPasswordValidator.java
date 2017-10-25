package com.epam.validation.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.epam.validation.service.PasswordValidator;

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

		Assert.assertTrue(validator.validatePassword("SUBBU123"));
		
	}

	@Test
	public void testFailureNumeric() {
		
		// No numeric
		Assert.assertFalse(validator.validatePassword("epamsystems"));
	}

	@Test
	public void testFailureMinLength() {
		
		// Min Length
		Assert.assertFalse(validator.validatePassword("epam"));
	}
	
	@Test
	public void testFailureMaxLength() {
		
		// Max Length
		Assert.assertFalse(validator.validatePassword("epamsytems1234"));
	}

}
