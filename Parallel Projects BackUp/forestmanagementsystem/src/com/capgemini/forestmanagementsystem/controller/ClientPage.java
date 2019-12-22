package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystem.exceptions.InvalidUserIdAndPassword;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class ClientPage {
	static Map<Integer, String> result=null;
	
	public static void clientPage() {

		Scanner sc=new Scanner(System.in); 
		ForestDao fd=FactoryClass.getForestDAOImplObject();
		
		result=ClientDetailsMain.getTheClientDetails();
		
		System.out.println("--------Enter Your Login Id and password----------");
		System.out.println("Enter the Client Id:");
		int usn=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Client Password");
		String pass=sc.nextLine();
		try {
		if(result.get(usn).equals(pass)) {
		System.out.println("\nUSER ID AND PASSWORD MATCHED SUCCESSFULLY\n");
			clientOperation();
		}
		else {
			System.err.println("\nINVALID USER ID AND PASSWORD !!\n");
			clientPage();
		}
		}//end of try bloack
		catch (NullPointerException e) {
			InvalidUserIdAndPassword iu=new InvalidUserIdAndPassword();
			iu.invalidUserIdandPassword();
			clientPage();
			// TODO: handle exception
		}

	} 

	public static void clientOperation() {
		Scanner sc=new Scanner(System.in); 
		System.out.println("\n----------------------CLIENT PAGE--------------------------------\n");
		System.out.println("PRESS 1 TO PERFORM CONTRACT OPERATION");  
		System.out.println("PRESS 2 TO PERFORM PRODUCT OPERATION");
		int option=sc.nextInt();
		switch (option) {
		case 1:
             ContractPage.adminContractOperation();
			break;
		case 2:
             ProductDetailsMain.productDetailsmain();
			break;
		default:
			break;
		}
		
		
		
	}
	
	
	
	

}
