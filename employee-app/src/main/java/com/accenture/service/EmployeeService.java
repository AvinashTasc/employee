package com.accenture.service;

import java.util.List;

import com.accenture.model.EmployeeModel;

//it will contain only method, in real project we have this type of interface available
public interface EmployeeService {
	
	public int insertEmployee(EmployeeModel pm);
	public List<EmployeeModel> printEmployees();
	public void removeEmployee(int empId);
	public EmployeeModel getEmployeeById(int empId);
	public int modifyEmployee(EmployeeModel pm);
	public List<EmployeeModel> sortEmployeesBySalary();
}
