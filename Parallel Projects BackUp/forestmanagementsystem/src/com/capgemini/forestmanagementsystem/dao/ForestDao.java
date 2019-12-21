package com.capgemini.forestmanagementsystem.dao;

import java.util.Map;

import com.capgemini.forestmanagementsystem.dto.ContractDetails;
import com.capgemini.forestmanagementsystem.dto.CustomerDetail;
import com.capgemini.forestmanagementsystem.dto.HaulierDetails;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;



public interface ForestDao {

	
public Map<Integer, ContractDetails> addTheContractDetails(ContractDetails cdbean);
	
	public Map<Integer, CustomerDetail> addTheCustomerDetails(CustomerDetail cd);
	
	
	public Map<Integer, ProductDetails> addTheProductDetails(ProductDetails pd);
	
	
	
	
}
