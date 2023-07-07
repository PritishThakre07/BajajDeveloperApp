package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Developer;

public interface DeveloperRepo extends JpaRepository<Developer,Long> {
	
	

}
