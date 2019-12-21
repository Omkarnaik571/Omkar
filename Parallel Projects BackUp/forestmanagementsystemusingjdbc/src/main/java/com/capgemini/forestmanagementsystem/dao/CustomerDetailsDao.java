package com.capgemini.forestmanagementsystem.dao;

public interface CustomerDetailsDao {
	 //1. add a Customer
	public void addCustomer();
//2. View all the Customers detail
	public void viewCustomerDetails();
//3. View single Customers detail
	public void viewSingleCustomerDetails();
//4. delete a Customers detail	
	public void deleteCustomerDetails();
//5. Modify a Customers detail	
	public void modifyCustomerDetails();
	
	
	
}
