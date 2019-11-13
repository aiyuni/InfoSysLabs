package com.ejb.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ejb.services.EmployeeService;
import com.jpa.entities.Employee;


@Stateless
public class EmployeeServiceImpl implements EmployeeService {

	@PersistenceContext(name = "EmployeeApp")
	private EntityManager em;

	@Override
	public void addEmployee(Employee emp) {

		em.persist(emp);

	}
	
    public Employee find(int id) {
        return em.find(Employee.class, 2);
    }
    
    public void removeEmployee(Employee product) {
        //attach product
        product = find(1);
        em.remove(product);
    }
    
    public List<Employee> getAllEmployees(){
    	
    	 TypedQuery<Employee> query = em.createQuery(
                 "select ps from Employee ps " +
                 "order by ps.employeeId, ps.firstName",
                 Employee.class); 
java.util.List<Employee> productSuppliers = 
     query.getResultList();
Employee[] psarray = 
     new Employee[productSuppliers.size()];
for (int i=0; i < psarray.length; i++) {
 psarray[i] = productSuppliers.get(i);
}
return Arrays.asList(psarray);

    
    }

}