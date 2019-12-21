package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class ProductDetailsMain {
	
	static Map<Integer, ProductDetails> result = null;
	

	public static void productDetailsmain() {
		ForestDao fd=FactoryClass.getForestDAOImplObject();
		
		
		ProductDetailsMain pm=new ProductDetailsMain();
		Scanner sc=new Scanner(System.in);
		ProductDetailsMain pdm=new ProductDetailsMain();
		
				while(true) {
					System.out.println("HERE ARE THE CHOICES: ");
					System.out.println("PRESS 1 TO ADD A NEW PRODUCT DETAIL");
					System.out.println("PRESS 2 TO VIEW ALL THE PRODUCT DETAILS");
					System.out.println("PRESS 3 TO VIEW A PARTICULAR PRODUCT DETAIL");
					System.out.println("PRESS 4 TO VIEW THE NUMBER OF PRODUCTS");	
					System.out.println("PRESS 5 TO DELETE A PRODUCT");
					System.out.println("PRESS 6 TO MODIFY A PRODUT");
					System.out.println("PRESS 7 TO GO TO ADMIN PAGE");
					System.out.println("PRESS 8 TO GO TO CLIENT PAGE");
					System.out.println("\nENTER YOUR CHOICE: --> "); 
					int choice=sc.nextInt();
					switch (choice) {
					case 1:
						ProductDetails pd=FactoryClass.getproductDetailsObject();
						System.out.println("--------ENTER THE PRODUCT DETAILS:-----------\n");
						//1. PRODUCT ID
						System.out.println("ENTER THE PRODUCT ID: ");
						pd.setProductid(sc.nextInt());
						//2. PRODUCT NAME
						System.out.println("ENTER THE PRODUCT NAME: ");
						pd.setProductname(sc.next());
						//3.Product QUANTITY:
						System.out.println("ENTER THE PRODUCT QUANTITY: ");
						pd.setProductquantity(sc.next());
						//Calling the ForestDAO impl
						result=fd.addTheProductDetails(pd);	
						System.out.println("\nPRODUCT ADDDED SUCCESSFULLY ^^^^\n");
						break;
					case 2:
						Set<Map.Entry<Integer, ProductDetails>>  s1=result.entrySet();                                
						System.out.println("\n----------THE PRODUCT DETAILS ARE:------------");
						System.out.println("*************************************************");
						for (Map.Entry<Integer, ProductDetails> entry : s1) {
							System.out.println("Details of Product number ("+entry.getKey()+")  ARE: ");
							System.out.print(entry.getValue()+"\n");
						}
						System.out.println("*************************************************");		
						System.out.println("------------------------------------------------");
						break;

					case 3:
						System.out.println("Enter the product Number Which yo want to see detail Of: ");
						int detail=sc.nextInt();
						boolean yes=result.containsKey(detail);
						if(yes==true) {
							System.out.println("\n----------THE PRODUCT DETAILS ARE:------------");
							System.out.println("*************************************************");
							System.out.println("Details of Product number "+detail+" is:");      
							Set<Map.Entry<Integer, ProductDetails>> s2=   result.entrySet();
							System.out.println(result.get(detail));	

							System.out.println("*************************************************");		
							System.out.println("------------------------------------------------");
						}
						else {
							System.out.println("\nThe Product Number that you have entered is not in the data base !!");
						}

						break;

					case 4:
						int size=result.size();
						System.out.println("\nNumber of Product in the Database = "+size+"\n");

						break; 

					case 5:
						System.out.println("Enter the Product number which you want to Delete:");
						int delete=sc.nextInt();
						result.remove(delete);
						break;
					case 6:
						System.out.println("Enter the Product Number Which yo want to Modify: ");
						int modify=sc.nextInt();
						if(result.containsKey(modify)){
							ProductDetails cdbean1=FactoryClass.getproductDetailsObject();
							System.out.println("--------Enter the revised Product Details:-----------\n");
							//1. PRODUCT ID
							System.out.println("ENTER THE PRODUCT ID: ");
							cdbean1.setProductid(sc.nextInt());
							//2. PRODUCT NAME
							System.out.println("ENTER THE PRODUCT NAME: ");
							cdbean1.setProductname(sc.next());
							//3.Product QUANTITY:
							System.out.println("ENTER THE PRODUCT QUANTITY: ");
							cdbean1.setProductquantity(sc.next());

							result.replace(modify, cdbean1);	
						}
						else {
							System.out.println("\nTHE PRODUCT NUMBER THAT YOU HAVE ENTERED IS NOT IN THE DATABASE !!!!!!!\n");
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
	
			}
			
	}
	//main method


