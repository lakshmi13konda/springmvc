package com.jfsfeb.springmvcass.dto;
import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data

public class EmployeeInfoBean implements Serializable{

	private int id;
	private String name;
	private long mobilenumber;
	private String emailId;
	@ToString.Exclude
	private String password;
	private int age;

	
}
