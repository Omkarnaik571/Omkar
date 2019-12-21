package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

public class ClientPage {
	
	public static void clientPage() {
		Scanner sc=new Scanner(System.in); 

		System.out.println("-----------CREATE YOUR ACCOUNT FIRST----------");
		System.out.println("Enter the Client Name:");
		String usn1=sc.nextLine();

		System.out.println("Enter the Client Password");
		String pass1=sc.nextLine();

		System.out.println("--------Enter Your Login Id and password----------");
		System.out.println("Enter the Client Name:");
		String usn2=sc.nextLine();
		System.out.println("Enter the Client Password");
		String pass2=sc.nextLine();
		if(usn1.equals(usn2) && pass1.equals(pass2)) {
			clientOperation();
		}
		else {
			System.err.println("Invalid User Name and Password..");
			clientPage();
		}

	} 

	public static void clientOperation() {
		Scanner sc=new Scanner(System.in); 
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
