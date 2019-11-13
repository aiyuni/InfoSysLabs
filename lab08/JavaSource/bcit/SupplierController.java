package bcit;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named("supplierController")
@SessionScoped
public class SupplierController implements Serializable {
 
	private Supplier supplier = new Supplier();
 
	@EJB
	private SupplierService service;
 
	public Supplier getSupplier() {
		return supplier;
	}
 
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
 
	public void saveSupplier(Supplier emp) {
		service.addSupplier(emp);
	}
	
	public void removeSupplier(Supplier emp) {
		service.removeSupplier(emp);
	}
	
	public List<Supplier> getAllSuppliers() {
		return service.getAll();
	}
 
}