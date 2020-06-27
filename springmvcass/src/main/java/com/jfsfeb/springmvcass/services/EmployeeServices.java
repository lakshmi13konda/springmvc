package com.jfsfeb.springmvcass.services;

import java.util.List;

import com.jfsfeb.springmvcass.dto.EmployeeInfoBean;

public interface EmployeeServices {

	public EmployeeInfoBean getEmployeeByid(int id);
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean updateEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(int Id);
	public List<EmployeeInfoBean> getAllEmployees();
	public EmployeeInfoBean authenticate(int empId,String password);
	
}
