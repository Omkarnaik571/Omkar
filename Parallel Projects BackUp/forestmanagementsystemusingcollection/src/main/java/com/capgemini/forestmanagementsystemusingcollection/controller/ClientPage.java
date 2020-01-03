package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystemusingcollection.service.ClientService;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;


public class ClientPage extends AdminClientOperation {
//	static ClientService clientService1=new ClientServiceImpl();

	public static void clientAuthentication() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("--------CLIENT PAGE------------");
		System.out.println("Enter username");
		String user=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		if(clientService.checkClient(user, pass)) {
			clientPage();
		}//end of if statement
		else {
			System.err.println("\nINVALID CLIENT USERNAME AND PASSWORD\n");
			while(true) {
				System.out.println("\n1. Go back to Admin Page ");
				System.out.println("\n2. Try LogIn Again");
				char a='n';
				String choice=null;
				while(a=='n') {
					choice=sc.next();

					if(Validations.isNumber1(choice)) {
						a='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}
				int option=Integer.parseInt(choice);
				switch (option) {
				case 1:
                     AdminPage.adminAuthentication();
					break;
				case 2:
                       System.out.println("------Try LogIn Again------");
                       clientAuthentication();
					break;
				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION\n");
					break;
				}

			}//end ofwhile
		}


	}







	public static void clientPage() {
		while(true) {
			Scanner sc=new Scanner(System.in); 
			System.out.println("\n----------------------CLIENT PAGE--------------------------------\n");
			System.out.println("PRESS 1 TO PERFORM CONTRACT OPERATION");  
			System.out.println("PRESS 2 TO PERFORM PRODUCT OPERATION");
			System.out.println("PRESS 3 TO MODIFY CLIENT PASSWORD");
			System.out.println("PRESS 4 TO GO TO ADMIN PAGE");
			char a='n';
			String choice=null;
			while(a=='n') {
				choice=sc.next();

				if(Validations.isNumber1(choice)) {
					a='x';
				}
				else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int option=Integer.parseInt(choice);
			switch (option) {
			case 1:
				ClientContractOperation.clientContractOperation();
				break;
			case 2:
				ClientProductOperation.clientProductOperation();
				break;
			case 3:

				break;
			case 4:
				AdminPage.adminPage();
				break;

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION\n");
				break;
			}


		}//end of while loop

	}//end of client page method


}//end of class
