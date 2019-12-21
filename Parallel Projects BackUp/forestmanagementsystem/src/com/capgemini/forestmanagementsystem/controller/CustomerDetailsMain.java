package com.capgemini.forestmanagementsystem.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dto.CustomerDetail;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class CustomerDetailsMain {
	static Map<Integer, CustomerDetail> result=null;
	
	public static void customerDetailsmain() {
		String adminname="admin";
		String adminpassword="root";
		Scanner sc=new Scanner(System.in);
		ForestDao fd=FactoryClass.getForestDAOImplObject();
		
		
		
		while(true) {
			CustomerDetail cd=FactoryClass.getCustomerDetailsObject();
			System.out.println("Here are the choices: ");
			System.out.println("Press 1 to add a new User");
			System.out.println("Press 2 to view all the Users Details");
			System.out.println("Press 3 to view a particular User ");
			System.out.println("Press 4 to view how many  users are there");	
			System.out.println("Press 5 to delete a customer");
			System.out.println("Press 6 to mofify a customer");
			System.out.println("Press 7 to go Admin  Page");
			System.out.println("\nEnter your Chice: --> "); 
			int   choice=sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("--------ENTER THE USER DETAILS:-----------\n");
				//1. Customer Id
				System.out.println("ENTER THE CUSTOMER ID: ");
				cd.setCustomerid(sc.nextInt());
				//2.CustomerName
				System.out.println("ENTER THE CUSTOMER  NAME: ");
				cd.setCustomername(sc.next());
				//3.StreetAddress1
				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 1: ");
				cd.setStreetAddress1(sc.next());
				//4.StreetAddress2
				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 2: ");
				cd.setStreetAddress2(sc.next());
				//5.Town
				System.out.println("ENTER THE CUSTOMER TOWN: ");
				cd.setTown(sc.next());
				//6. Postal Code
				System.out.println("ENTER THE CUSTOMER POSTAL CODE: ");
				cd.setPostalcode(sc.nextInt());
				//7.E mail
				System.out.println("ENTER THE CUSTOMER E-MAIL: ");
				cd.setEmail(sc.next());
				//8. Phone number
				System.out.println("ENTER THE CUSTOMER PHONE NUMBER: ");
				cd.setTelephoneno(sc.nextInt());
				result=fd.addTheCustomerDetails(cd);
				break;
			case 2:
				Set<Map.Entry<Integer, CustomerDetail>>  s1=result.entrySet();                                
				System.out.println("\n----------THE CUSTOMER DETAILS ARE:------------");
				System.out.println("*************************************************");
				for (Map.Entry<Integer, CustomerDetail> entry : s1) {
					System.out.println("DETAIL OF THE CUSTOMER ("+entry.getKey()+") are: ");
					System.out.print(entry.getValue()+"\n");
				}
				
				System.out.println("*************************************************");		
				System.out.println("------------------------------------------------");
               
				break;
			case 3:
				System.out.println("ENTER THE USER NUMBER WHICH YOU WANT TO SEE DETAIL OF: ");
        	    int detail=sc.nextInt();
        	    boolean yes=result.containsKey(detail);
        	    if(yes==true) {
        	    	System.out.println("\n----------THE CUSTOMER DETAILS ARE:------------");
        			System.out.println("*************************************************");
        	    	System.out.println("DETAIL OF THE CUSTOMER NUMBER "+detail+" IS:");       
        	    	     System.out.println(result.get(detail));
        	    	       System.out.println("*************************************************");		
        	   			System.out.println("------------------------------------------------");
        	    }
        	    else {
        	    	System.out.println("\n THE CUSTOMER NUMBER WHICH YOU HAVE ENTERED IS NOT IN THE DATABASE !!\n");
        	    }

				break;
			case 4:
				int size=result.size();
	        	System.out.println("\nTOTAL NUMBER OF USERS PRESENT IN THE DATABASE = "+size+"\n");
				
				break;
				
			case 5:
				System.out.println("ENTER THE CUSTOMER NUMBER WHICH YOU WANT TO DELETE:");
				int delete=sc.nextInt();
				result.remove(delete);

				break;
				
			case 6:
				System.out.println("ENTER THE USER NUMBER WHICH YOU WANT TO MODIFY: ");
        	    int modify=sc.nextInt();
        	    if(result.containsKey(modify)) {
        	    	CustomerDetail cd1=FactoryClass.getCustomerDetailsObject();
            	    System.out.println("--------ENTER THE REVISED USER DETAILS:-----------\n");
    				//1. Customer Id
    				System.out.println("ENTER THE CUSTOMER ID: ");
    				cd1.setCustomerid(sc.nextInt());
    				//2.CustomerName
    				System.out.println("ENTER THE CUSTOMER  NAME: ");
    				cd1.setCustomername(sc.next());
    				//3.StreetAddress1
    				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 1: ");
    				cd1.setStreetAddress1(sc.next());
    				//4.StreetAddress2
    				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 2: ");
    				cd1.setStreetAddress2(sc.next());
    				//5.Town
    				System.out.println("ENTER THE CUSTOMER TOWN: ");
    				cd1.setTown(sc.next());
    				//6. Postal Code
    				System.out.println("ENTER THE CUSTOMER POSTAL CODE: ");
    				cd1.setPostalcode(sc.nextInt());
    				//7.E mail
    				System.out.println("ENTER THE CUSTOMER E-MAIL: ");
    				cd1.setEmail(sc.next());
    				//8. Phone number
    				System.out.println("ENTER THE CUSTOMER PHONE NUMBER: ");
    				cd1.setTelephoneno(sc.nextInt());
            	        result.replace(modify,cd1);	
        	    }
        	    else {
	    	    	System.out.println("\nTHE CUSTOMER NUMBER THAT YOU HAVE ENTERED IS NOT IN THE DATABASE !!!!!!!\n");
	    	    }    
				break;
				
			case 7:
				AdminPage.adminPage();
				break;
			default:
				break;
			}




		}



		


	}



	
	
	
}
