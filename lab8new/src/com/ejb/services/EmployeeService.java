package com.ejb.services;

import java.util.List;

import com.jpa.entities.Employee;

public interface EmployeeService {

	public void addEmployee(Employee emp);
	public void removeEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	
}