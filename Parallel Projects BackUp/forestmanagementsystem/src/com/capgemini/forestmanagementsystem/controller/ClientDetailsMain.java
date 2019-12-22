package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;



public class ClientDetailsMain {
	static Map<Integer, String> result=null;


	public static void clientDetailsMain() {
		Scanner sc=new Scanner(System.in);
		ForestDao fd=FactoryClass.getForestDAOImplObject();
		while(true) {
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW CLIENT");
			System.out.println("PRESS 2 TO VIEW ALL THE CLIENT DETAILS");	
			System.out.println("PRESS 3 TO DELETE A CLIENT");
			System.out.println("PRESS 4 TO MODIFY A CLIENT");
			System.out.println("PRESS 5 TO GO TO ADMIN PAGE");
			System.out.println("PRESS 6 TO GO TO CLIENT PAGE");
			System.out.println("\nENTER YOUR CHOICE: --> "); 
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				result=fd.addTheClientDetails();
				System.out.println("\nCLIENT ADDED SUCCESSFULLY !!\n");
				break;
			case 2:
				try {  
					Set<Map.Entry<Integer, String>> s1= result.entrySet();
					System.out.println("^^^^^^^^^^^^^^^^THE CLIENT DETAILS ARE^^^^^^^^^^^^^^^^^^");
					for (Map.Entry<Integer, String> entry : s1) {
						System.out.println("Client Id : "+entry.getKey());
						System.out.println("Password : "+entry.getValue());
						System.out.println("----------------------------------------------------------------------------------------------");
					}
				} 
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForClient();
				}
				break;
			case 3:
				System.out.println("ENTER THE CLIENT ID WHICH YOU WANT TO DELETE : ");
				int delete=sc.nextInt();
				result.remove(delete);
				System.out.println("\nCLIENT DELETED SUCCESSFULLY !!\n");
				break;
			case 4:
				System.out.println("ENTER THE CLIENT ID  : ");
				int modifyid=sc.nextInt();
				sc.nextLine();
				if(result.containsKey(modifyid) ) {
					System.out.println("ENTER THE REVISED CLIENT PASSWORD");
					String modifypass=sc.nextLine();   
					result.replace(modifyid, modifypass);
					System.out.println("\nCLIENT PASSWORD MODIFIED SUCCESSFULLY !!\n");	   
				}
				else {
                     System.err.println("\nTHE CLIENT ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE !!\n");;
				}

				break;
			case 5:
				AdminPage.adminPage();
				break;
			case 6:
				ClientPage.clientPage();
				break;
			default:
				System.err.println("\nENTER A VALID OPTION\n");
				break;
			}




		}//end of while loop

	}//end of client details main method..

	public static Map<Integer, String> getTheClientDetails() {

		return result;
	}

}
