package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dto.LandDetails;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;
import com.capgemini.forestmanagementsystem.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class LandDetailsMain {
	static Map<Integer, LandDetails> result = null;

	public static void landDetailsMain() {
		ForestDao fd=FactoryClass.getForestDAOImplObject();
		LandDetails ld=new LandDetails();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW LAND DETAIL");
			System.out.println("PRESS 2 TO VIEW ALL THE LAND DETAILS");
			System.out.println("PRESS 3 TO VIEW A PARTICULAR LAND DETAIL");
			System.out.println("PRESS 4 TO VIEW THE NUMBER OF LAND DETAILS");	
			System.out.println("PRESS 5 TO DELETE A LAND DETAIL");
			System.out.println("PRESS 6 TO MODIFY A LAND DETAIL");
			System.out.println("PRESS 7 TO GO TO ADMIN PAGE");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("\nENTER THE PLOT NUMBER : ");
				ld.setPlotnumber(sc.nextInt());
				System.out.println("\nENTER THE OWNER NAME : ");
				ld.setOwner(sc.next());
				System.out.println("\nENTER THE ACQUIRED DATE : ");
				ld.setAcquireddate(sc.next());
				System.out.println("\nENTER THE LAND PRICE: ");
				ld.setPrice(sc.nextDouble());
				result=fd.addTheLandDetails(ld);
				System.out.println("\nLAND DETAILS ADDES SUCCESSFULLY !!\n");
				break;
			case 2:
				try {
					Set<Map.Entry<Integer, LandDetails>>  s1=result.entrySet();                                
					System.out.println("\n----------THE PRODUCT DETAILS ARE:------------");
					System.out.println("*************************************************");
					for (Map.Entry<Integer, LandDetails> entry : s1) {
						System.out.println("Details of Land id ("+entry.getKey()+")  ARE: ");
						System.out.print(entry.getValue()+"\n");
						System.out.println("------------------------------------------------");
					}
					System.out.println("*************************************************");	
				}
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e=new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForLand();
					// TODO: handle exception
				}
				break;
			case 3:
				try {
				System.out.println("Enter the Land Id Which yo want to see detail Of: ");
				int detail=sc.nextInt();
				boolean yes=result.containsKey(detail);
				if(yes==true) {
					System.out.println("\n----------THE LAND DETAILS ARE:------------");
					System.out.println("*************************************************");
					System.out.println("Details of Land Id "+detail+" is:");      
					Set<Map.Entry<Integer, LandDetails>> s2=   result.entrySet();
					System.out.println(result.get(detail));	
					System.out.println("*************************************************");		
					System.out.println("------------------------------------------------");
				}
				else {
					System.out.println("\nThe Land Id that you have entered is not in the data base !!");
				}
				}//end of try
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForLand();
				}

				break;
			case 4:
				try {
					int size=result.size();
					System.out.println("\nNumber of Land Details in the Database = "+size+"\n");
				}
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForLand();
				}

				break;
			case 5:
				System.out.println("Enter the Land Id which you want to Delete:");
				int delete=sc.nextInt();
				result.remove(delete);
				System.out.println("\nLand Detail DELETED SUCCESSFULLY\n");

				break;
			case 6:
				System.out.println("\nENTER THE LAND ID : \n");
				int landid=sc.nextInt();
				if(result.containsKey(landid) ) {
					LandDetails ld1=result.get(landid);
					System.out.println("1 MODIFY OWNER NAME : ");
					System.out.println("2 MODIFY ACQUIRED DATE : ");
					System.out.println("3 MODIFY LAND PRICE: ");
					int mod=sc.nextInt();
					switch (mod) {
					case 1:
						System.out.println("\nENTER REVISED OWNER NAME : ");
                        ld1.setOwner(sc.next());
                        result.replace(landid, ld1);
                        System.out.println("\nOWNER NAME MODIFIED SUCCESSFULLY !!\n");
						break;
					case 2:
						System.out.println("\nENTER REVISED ACQUIRED DATE : ");
                        ld1.setAcquireddate(sc.next());
                        result.replace(landid, ld1);
                        System.out.println("\nACQUIRED DATE MODIFIED SUCCESSFULLY !!\n");
						break;
					case 3:
						System.out.println("\nENTER REVISED  LAND PRICE : ");
                        ld1.setPrice(sc.nextDouble());
                        result.replace(landid, ld1);
                        System.out.println("\nLAND PRICE MODIFIED SUCCESSFULLY !!\n");
						break;
					default:
						System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
						break;
					}	
					
				}
				else {
					System.err.println("\nTHE LAND ID THAT YOU HAVE ENTERED IS NOT IN THE DATABASE  !!\n");
				}
				break;
			case 7:
				AdminPage.adminPage();
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
				break;
			}




		}//end of while loop





	}









}
