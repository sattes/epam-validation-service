package com.epam.validation.service.test;

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

		Assert.assertTrue(validator.validatePassword("subsub123"));
		
	}
	
	@Test
	public void testFailureForUppercase() {

		Assert.assertFalse(validator.validatePassword("SUBBU123"));
		
	}
	
	@Test
	public void testFailureForLowerAndUppercase() {

		Assert.assertFalse(validator.validatePassword("SUbbu123"));
		
	}

	@Test
	public void testFailureForNumeric() {
		
		// No numeric
		Assert.assertFalse(validator.validatePassword("epamsystems"));
	}

	@Test
	public void testFailureForMinLength() {
		
		// Min Length
		Assert.assertFalse(validator.validatePassword("epam"));
	}
	
	@Test
	public void testFailureForMaxLength() {
		
		// Max Length
		Assert.assertFalse(validator.validatePassword("epamsytems1234"));
	}

}
