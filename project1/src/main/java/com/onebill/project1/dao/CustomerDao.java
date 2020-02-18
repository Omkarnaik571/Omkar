package com.onebill.project1.dao;

import java.util.List;

import com.onebill.project1.dto.Customer;

public interface CustomerDao {

	public int addCustomer(Customer customer);
	
	public boolean deleteCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);
	
	public int reviseCustomer(Customer customer);
	
	
	public Customer viewCustomer(Customer customer);
	
	public List<Customer> viewAllCustomers();
	

}
