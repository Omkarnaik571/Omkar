package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ClientDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class AdminPage {

	private static String[] args;

	public static void adminOperation( ) {
		ClientDetailsDto cld=FactoryClass.getClientDetailsDto();
		CustomerDetailsDto cud=FactoryClass.getCustomerDetailsDto();
		LandDetailsDto ld=FactoryClass.getLandDetailsDto();

		


		System.out.println("\n------------------------ADMIN PAGE-----------------------------\n");
		System.out.println("1 FOR CLIENT  OPEARTION");
		System.out.println("2 FOR CUSTOMER  OPEARTION");
		System.out.println("3 FOR LAND  OPEARTION");
		System.out.println("4 FOR GOING BACK TO HOME PAGE");

		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			clientOperations();
			break;
		case 2:
			customerOperations();
			break;
		case 3:
			landOperations();
			break;
		case 4:
			HomePage.main(args);
			break;

		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			adminOperation();
			break;
		}

	}




	public static void clientOperations() {
		ClientDetailsDao cdd=FactoryClass.getClientDetailsDaoImpl();
		System.out.println("--------------------CLIENT OPERATIONS------------------");
		System.out.println("1 ADD A CLIENT");
		System.out.println("2 DELETE A CLIENT");
		System.out.println("3 VIEW  CLIENT LISTS");
		System.out.println("4 MODIFY CLIENT DETAILS");
		System.out.println("5 GO BACK TO ADMIN PAGE");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
             cdd.addClient();
			break;
		case 2:
             cdd.deleteClient();
			break;
		case 3:
              cdd.viewAllClient();
			break;
		case 4:
          cdd.modifyClient();
			break;
		case 5:
	          adminOperation();
				break;
		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			clientOperations();
			break;
		}





	}
	//client opeartion end

	public static void customerOperations() {
		CustomerDetailsDao cdd=FactoryClass.getCustomerDetailsDaoImpl();
		System.out.println("Press 1 to add a new Customer Details");
		System.out.println("Press 2 to view all the Customer Details");
		System.out.println("Press 3 to view a particular Customer Detail ");	
		System.out.println("Press 4 to delete a Customer");
		System.out.println("Press 5 to Modify a Customer");
		System.out.println("6 GO BACK TO ADMIN PAGE");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch (option) {
		case 1:
			//Add a customer detail
			cdd.addCustomer();
			break;
		case 2:
			//View all customer detail
			cdd.viewCustomerDetails();
			
			break;
		case 3:
            //View a particular customer
			cdd.viewSingleCustomerDetails();
			break;
		case 4:
            //delete a customer
			cdd.deleteCustomerDetails();
			break;
		case 5:
            //modify a customer
			cdd.modifyCustomerDetails();
			break;
		case 6:
           adminOperation();
			break;
		default:
			break;
		
		}
	   
		




	}
	//customer operation end

	public static void landOperations() {
		LandDao ld=FactoryClass.getLandDaoImpl();
		System.out.println("--------------------CLIENT OPERATIONS------------------");
		System.out.println("1 ADD A LAND DETAIL");
		System.out.println("2 DELETE A LAND DETAIL");
		System.out.println("3 VIEW  LAND DETAILS");
		System.out.println("4 MODIFY LAND DETAILS");
		System.out.println("5 GO BACK TO ADMIN PAGE");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
            ld.addLand();
			break;
		case 2:
             ld.deleteLand();
			break;
		case 3:
              ld.viewAllLand();
			break;
		case 4:
          ld.modifyLand();
			break;
		case 5:
	          adminOperation();
				break;
		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			landOperations();
			break;
		}
		
		



	}
	//land opeartion end


}
