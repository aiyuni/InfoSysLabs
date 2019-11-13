package bcit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



@Stateless
public class SupplierService {

	@PersistenceContext(name = "EmployeeApp")
	private EntityManager em;

	public void addSupplier(Supplier emp) {

		em.persist(emp);

	}
	
    public Supplier find(int id) {
        return em.find(Supplier.class, id);
    }
    
    public void removeSupplier(Supplier supplier) {
        //attach product
      //  supplier = find(supplier.getSupplierId());
       // em.remove(supplier);
    }
    
    public List<Supplier> getAll() {
        TypedQuery<Supplier> query = em.createQuery("select s from Supplier s",
                Supplier.class); 
        java.util.List<Supplier> suppliers = query.getResultList();
        Supplier[] suparray = new Supplier[suppliers.size()];
        for (int i=0; i < suparray.length; i++) {
            suparray[i] = suppliers.get(i);
        }
        List<Supplier> list = Arrays.asList(suparray);
        return list;
    }

}