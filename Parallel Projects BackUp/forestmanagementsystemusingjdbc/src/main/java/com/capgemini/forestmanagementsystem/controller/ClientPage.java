package com.capgemini.forestmanagementsystem.controller;

import java.io.Console;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class ClientPage {
	  
	static Scanner sc=new Scanner(System.in);


	private static String[] args;

	public static void clientOperation( ) {
	

		System.out.println("\n------------------------CLIENT PAGE-----------------------------\n");
		System.out.println("1 FOR CONTRACTOR  OPEARTION");
		System.out.println("2 FOR PRODUCT  OPEARTION");
		System.out.println("3 FOR GOING BACK TO HOME PAGE");


		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			contractorOperations();
			break;
		case 2:
		   productOperations();
			break;
		case 3:
			HomePage.main(args);
			break;
		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			break;
		}


	}//end of client opearations


	public static void contractorOperations() {
	
		ContractorDetailsDao cdd=FactoryClass.getContractorDaoImpl();
		System.out.println("--------------------CONTRACT OPERATIONS------------------");
		System.out.println("1 ADD A CONTRACTOR");
		System.out.println("2 DELETE A CONTRACTOR");
		System.out.println("3 VIEW  CONTRACTOR");
		System.out.println("4 MODIFY CONTRACTOR DETAILS");
		System.out.println("5 GO BACK TO CLIENT PAGE");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			cdd.addContractor();
			break;
		case 2:
			cdd.deleteContractorDetails();
			break;
		case 3:
			cdd.viewSingleContractorDetails();
			break;
		case 4:
			cdd.modifyContractorDetails();
			break;
		case 5:
			clientOperation();
			break;
		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			clientOperation();
			break;
		}



	}//end of customer operations
	
	public static void productOperations()  {
	
		String ch="yes";
		while(ch.equals("yes")) {
		ProductDao pd=FactoryClass.getProductDaoImpl();
		System.out.println("Press 1 to add a new Product Details");
		System.out.println("Press 2 to view a particular  Product Detail ");	
		System.out.println("Press 3 to view All  Product Detail ");	
		System.out.println("Press 4 to delete a  Product");
		System.out.println("Press 5 to Modify a  Product Detail");
		System.out.println("Press 6 to go Client Page");
		System.out.println("\nEnter your Chice: --> "); 
		int option=sc.nextInt();
		switch (option) {
		case 1:
             boolean isAdded=pd.addProduct();
             System.out.println("If You want to continue type yes  or type anything");
             ch=sc.next();
			break;
		case 2:
              pd.viewParticularProduct();
			break;
		case 3:
             pd.viewAllProduct();
			break;
		case 4:
             pd.deleteProduct();
			break;
		case 5:
           pd.modifyProduct();
			break;
		case 6:
	           clientOperation();
				break;
		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			productOperations();
			break;
		}

		}//end of while
	}//end of product operations


}
