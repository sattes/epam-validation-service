package com.epam.validation.service;

import org.springframework.stereotype.Service;

@Service
public interface PasswordValidator {

	public boolean validatePassword(String password);

}
