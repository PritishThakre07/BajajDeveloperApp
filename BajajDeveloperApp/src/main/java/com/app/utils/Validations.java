package com.app.utils;

import java.util.Arrays;

public class Validations {
	
	
	public static String validEmail(String email) {
		
		
		  if( email.contains("@")) {
			  return email;
		  }
		  
		 return null;
	}

	
}
