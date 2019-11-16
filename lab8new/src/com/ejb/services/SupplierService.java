package com.ejb.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.jpa.entities.Supplier;




@Stateless
public class SupplierService {

	@PersistenceContext(name = "EmployeeApp")
	private EntityManager em;

	List<Supplier> supplierList;
	
	public void addSupplier(Supplier emp) {

		em.persist(emp);
		supplierList.add(emp);

	}
	
    public Supplier find(int id) {
        return em.find(Supplier.class, id);
    }
    
    public void removeSupplier(Supplier supplier) {
        //attach product
        supplier = find(supplier.getSupplierId());
        em.remove(supplier);
    }
    
    public void merge(Supplier supplier) {
        em.merge(supplier);
    }
    
    public List<Supplier> getAllSuppliers() {
        TypedQuery<Supplier> query = em.createQuery("select s from Supplier s",
                Supplier.class); 
        java.util.List<Supplier> suppliers = query.getResultList();
        Supplier[] suparray = new Supplier[suppliers.size()];
        for (int i=0; i < suparray.length; i++) {
            suparray[i] = suppliers.get(i);
        }
        ArrayList<Supplier> tempSupplierList = new ArrayList<Supplier>();
        for (int i = 0; i <suparray.length; i++) {
        	tempSupplierList.add(suparray[i]);
        }
        List<Supplier> list = Arrays.asList(suparray);
        supplierList = tempSupplierList;
        return tempSupplierList;
    }
    
}