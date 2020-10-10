package dao;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.Pagination;
import proxy.Proxy;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cust);
	public List<CustomerDTO> selectCustomerList(Proxy pxy);
	public List<CustomerDTO> selectCustomers(Proxy pxy);
	public CustomerDTO selectCustomer(CustomerDTO cust);
	public int countCustomers(Proxy pxy);
	public boolean existsCustomerID(CustomerDTO cust);
	public void updateCustomer(CustomerDTO cust);
	public Map<String, Object> selectProfile(Proxy pxy);
	public void deleteCustomer(CustomerDTO cust);
	public Map<String, Object> selectPhone(Proxy pxy); 
}
