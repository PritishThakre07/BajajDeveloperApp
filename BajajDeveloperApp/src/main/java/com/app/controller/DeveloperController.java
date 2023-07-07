package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Developer;
import com.app.service.DeveloperSevice;

@RestController
@CrossOrigin("*")
@RequestMapping("Automation-Cumpus")

public class DeveloperController {
	
	
	@Autowired
	private DeveloperSevice service ;
	
	
	@PostMapping("/create/user")
	@ResponseStatus(value=HttpStatus.CREATED)
	public String createUser( @Valid Developer de) {
		
		
		return service.createEntity(de);
	}

}
