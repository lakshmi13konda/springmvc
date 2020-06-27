package com.jfsfeb.springmvcass.dao;

import java.util.List;

import com.jfsfeb.springmvcass.dto.EmployeeInfoBean;

public interface EmployeeDAO {
	
	public EmployeeInfoBean getEmployeeByid(int Id);
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean updateEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(int Id);
	public List<EmployeeInfoBean> getAllEmployees();
	public EmployeeInfoBean authenticate(int empId,String password);

}
