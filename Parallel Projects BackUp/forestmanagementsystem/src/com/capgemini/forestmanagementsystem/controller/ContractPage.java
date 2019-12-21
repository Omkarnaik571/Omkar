package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dto.ContractDetails;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class ContractPage {

	static Map<Integer, ContractDetails> result=null;
	
	public static void adminContractOperation() {
		String adminname="admin";
		String adminpassword="root";

		ForestDao fd=FactoryClass.getForestDAOImplObject();

		ContractDetails cdbean=FactoryClass.getContractDetailsObject();


		try(Scanner sc=new Scanner(System.in);){
				while(true) {
					System.out.println("Here are the choices: ");
					System.out.println("Press 1 to add a new Contract Details");
					System.out.println("Press 2 to view all the Contract Details through Contract No");
					System.out.println("Press 3 to view a particular Contract Detail through Contract No");
					System.out.println("Press 4 to viws how many  contractors are there");	
					System.out.println("Press 5 to delete a Contractor");
					System.out.println("Press 6 to Modify a Contractor Detail");
					System.out.println("Press 7 to go Admin Page");
					System.out.println("Press 8 to go Client Page");
					System.out.println("\nEnter your Chice: --> "); 
					int   choice=sc.nextInt();


					switch (choice) {
					case 1:
						System.out.println("--------Enter the Contract Details:-----------\n");
						//1. Contract Number
						System.out.println("Enter the Contract Number: ");
						cdbean.setContractno(sc.nextInt());
						//2. Customer Id
						System.out.println("Enter the Customer Id: ");
						cdbean.setCustomerid(sc.nextInt());
						//3.Product Id:
						System.out.println("Enter the Product Id: ");
						cdbean.setProductid(sc.nextInt());
						//4. Haulier Id:
						System.out.println("Enter the Haulier Id: ");
						cdbean.setHaulierid(sc.nextInt());
						//							System.out.println();
						//5. Delivery Date:
						System.out.println("Enter the Delivery Date: ");
						cdbean.setDeliverydate(sc.next());
						//6. Delivery day
						System.out.println("Enter the Delivery Day: ");
						cdbean.setDeliveryday(sc.next());
						//7.
						System.out.println("Enter the Quantity: ");
						cdbean.setQuantity(sc.nextInt());

						//Calling the ForestDAO impl
						result=fd.addTheContractDetails(cdbean);	
						System.out.println("\nCONTRACTOR ADDDED SUCCESSFULLY ^^^^\n");

						break;
					case 2:
						Set<Map.Entry<Integer, ContractDetails>>  s1=result.entrySet();                                
						System.out.println("\n----------THE CONTRACT DETAILS ARE:------------");
						System.out.println("*************************************************");
						for (Map.Entry<Integer, ContractDetails> entry : s1) {
							System.out.println("Details of Contract number ("+entry.getKey()+")  ARE: ");
							System.out.print(entry.getValue()+"\n");
						}
						System.out.println("*************************************************");		
						System.out.println("------------------------------------------------");
						break;

					case 3:
						System.out.println("Enter the Contract Number Which yo want to see detail Of: ");
						int detail=sc.nextInt();
						boolean yes=result.containsKey(detail);
						if(yes==true) {
							System.out.println("\n----------THE CONTRACT DETAILS ARE:------------");
							System.out.println("*************************************************");
							System.out.println("Details of Contract number "+detail+" is:");      
							Set<Map.Entry<Integer, ContractDetails>> s2=   result.entrySet();
							System.out.println(result.get(detail));	

							System.out.println("*************************************************");		
							System.out.println("------------------------------------------------");
						}
						else {
							System.out.println("\nThe Contractor Number that you have entered is not in the data base !!");
						}

						break;

					case 4:
						int size=result.size();
						System.out.println("\nNumber of Contractors in the Database = "+size+"\n");

						break; 

					case 5:
						System.out.println("Enter the Contractor number which you want to Delete:");
						int delete=sc.nextInt();
						result.remove(delete);
						break;
					case 6:
						System.out.println("Enter the Contract Number Which yo want to Modify: ");
						int modify=sc.nextInt();
						if(result.containsKey(modify)) {
							ContractDetails cdbean1=FactoryClass.getContractDetailsObject();
							System.out.println("--------Enter the revised contract Details:-----------\n");

							//1. Contract Number
							System.out.println("Enter the Contract Number: ");
							cdbean1.setContractno(sc.nextInt());
							//2. Customer Id
							System.out.println("Enter the Customer Id: ");
							cdbean1.setCustomerid(sc.nextInt());
							//3.Product Id:
							System.out.println("Enter the Product Id: ");
							cdbean1.setProductid(sc.nextInt());
							//4. Haulier Id:
							System.out.println("Enter the Haulier Id: ");
							cdbean1.setHaulierid(sc.nextInt());

							//5. Delivery Date:
							System.out.println("Enter the Delivery Date: ");
							cdbean1.setDeliverydate(sc.next());
							//6. Delivery day
							System.out.println("Enter the Delivery Day: ");
							cdbean1.setDeliveryday(sc.next());
							//7.
							System.out.println("Enter the Quantity: ");
							cdbean1.setQuantity(sc.nextInt());
							result.replace(modify, cdbean1);	
						}
						else {
							System.out.println("\nTHE CONTRACTOR NUMBER THAT YOU HAVE ENTERED IS NOT IN THE DATABASE !!!!!!!\n");
						} 
			        break;
					case 7:
                         AdminPage.adminPage();
						break;
					case 8:
                       ClientPage.clientPage();
						break;

					default:
						break;
					}


				}
				//While End
		}
		//Try end

		catch (Exception e) {
			// TODO: handle exception
		}






	}





}
