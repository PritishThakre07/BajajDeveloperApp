package com.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.pojos.Developer;
import com.app.repository.DeveloperRepo;

@Transactional
@Service
public class DeveloperSeviceImpl implements DeveloperSevice{

	@Autowired
	private DeveloperRepo repo ;
	
	
	
	@Override
	public boolean validateEmail(String email) {
		
		
		Set<String> setEmail = repo.findAll().stream().map(t -> t.getEmail()).collect(Collectors.toSet());
		
		Set<String> emailSet = new HashSet<String>(setEmail);		
		
		if(email.contains("@")) {
			
			if(emailSet.add(email)) {
				
				return true;		
			}
		}
		return false;
		
	}

	@Override
	public boolean validatePhno(String phno) {
		
		
		Set<String> setList = repo.findAll().stream().map(t -> t.getPhoneNo()).collect(Collectors.toSet());
		
		Set<String> phList = new HashSet<String>(setList);
		
		char[] ch = phno.toCharArray(); 
		
		if(ch.length == 10) {
			
			if(phList.add(phno)) {
				
				return true;
			}else {
				throw new ValidationException("Phone Number Duplicate");
			}
			
		}else {
			throw new ValidationException("Number Should Be Ten Digit");
			
		}
	
		
	}
	@Override
	public boolean validateRoll(int roll) {
		
		if(roll == 0) 
			return false;
		
		throw new ValidationException("Phone Number Cant Be Zero");
	}
	
	public ResponseEntity<String> createEntity(Developer de) {
		
		if(validateEmail(de.getEmail())) {
			if(validatePhno(de.getPhoneNo())) {
				if(validateRoll(de.getRollNo())) {
					
					repo.save(de);
					return new ResponseEntity<String>("Ragistration Done Succcesfully",HttpStatus.CREATED);
							
				}
			}
		}
		
		ResponseEntity<String> resp  = new ResponseEntity<String>("Invalid Credential : Try Again",HttpStatus.BAD_REQUEST);
		
		return  resp;
	}


	

	
	
}
