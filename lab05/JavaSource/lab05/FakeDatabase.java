package lab05;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FakeDatabase {

	private List<Customer> customerList = new ArrayList<Customer>();
	
	@PostConstruct
    public void init() {
    	customerList.add(new Customer(1, "Perry", "Li", "1111 address", "bc", "vancouver", "abcdefg", "111-111-1111", "perry0406@hotmail.com"));
    }
    
	public FakeDatabase() {
		
		customerList.add(new Customer(1, "Perry", "Li", "1111 address", "bc", "vancouver", "abcdefg", "111-111-1111", "perry0406@hotmail.com"));
		
	}
	
	public List<Customer> getCustomerList(){
		return this.customerList;
	}
	
	
}
