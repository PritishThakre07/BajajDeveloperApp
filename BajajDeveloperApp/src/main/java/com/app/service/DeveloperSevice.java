package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Developer;

public interface DeveloperSevice {
	
	
	boolean validateEmail(String email);
	
	boolean validatePhno(String phno);
	
	ResponseEntity<String> createEntity(Developer de);
	
	boolean validateRoll(int roll);
	
	
	
	

}
