package com.capgemini.forestmanagementsystem.dao;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystem.dto.ContractDetails;
import com.capgemini.forestmanagementsystem.dto.CustomerDetail;
import com.capgemini.forestmanagementsystem.dto.HaulierDetails;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;


public class ForestDaoImpl implements ForestDao {

	
	Map<Integer, ContractDetails> m1=new TreeMap<Integer, ContractDetails>();
	Map<Integer, CustomerDetail> m2=new TreeMap<Integer, CustomerDetail>();
	Map<Integer, ProductDetails> m3=new TreeMap<Integer, ProductDetails>();
	Map<Integer, HaulierDetails> m4=new TreeMap<Integer, HaulierDetails>();
	
	@Override
	public Map<Integer, ContractDetails> addTheContractDetails(ContractDetails cdbean) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Contractor Number: ");
		int contractorno=sc.nextInt();
		m1.put(contractorno, cdbean);
		
		return m1;
	}

	@Override
	public Map<Integer, CustomerDetail> addTheCustomerDetails(CustomerDetail cd) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User Number: ");
		int userno=sc.nextInt();
		m2.put(userno, cd);
		
		return m2;
	}

	@Override
	public Map<Integer,ProductDetails> addTheProductDetails(ProductDetails pd) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Product Number: ");
		int productno=sc.nextInt();
		m3.put(productno, pd);
		return m3;
	}

	

	
	
	
	
}
