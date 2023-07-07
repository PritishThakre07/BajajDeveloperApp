package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="developer_info")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Developer extends BaseClass {
	
	@Column(name="roll_no",unique = true , nullable = false )
	@NotBlank(message = "Roll No is required!!!!")
	private int rollNo;
	
	
	@Column(name="firstName",nullable = false)
	@NotBlank(message = "Fist Name is required!!!!")
	private String firstName;
	
	@Column(name="lastName", nullable = false)
	@NotBlank(message = "Last Name is required!!!!")
	private String lastName;
	
	@Column(name="email",unique = true , nullable = false)
	@NotBlank(message = "Email is required!!!!")
	private String email;
	
	@Column(name="phoneNo",unique = true , nullable = false)
	@NotBlank(message = "Phone No is required!!!!")
	private String phoneNo;
	
	
	
	

}
