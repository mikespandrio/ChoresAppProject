package com.teamtrouble.choresapplication.web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String userId, String password) {
		// TODO: Validate against database with hashed password
		// For now, userId = admin and password = password
		
		
		return userId.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password");
	}
}
