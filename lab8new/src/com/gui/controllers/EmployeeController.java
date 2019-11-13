package com.gui.controllers;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.ejb.services.EmployeeService;
import com.jpa.entities.Employee;
 
@Named("employeeController")
@SessionScoped
public class EmployeeController implements Serializable {
 
	private Employee employee = new Employee();
 
	@EJB
	private EmployeeService service;
 
	public Employee getEmployee() {
		return employee;
	}
 
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
 
	public void saveEmployee(Employee emp) {
		service.addEmployee(emp);
	}
	
	public void removeEmployee(Employee emp) {
		service.removeEmployee(emp);
	}
	
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
		
	}
 
}