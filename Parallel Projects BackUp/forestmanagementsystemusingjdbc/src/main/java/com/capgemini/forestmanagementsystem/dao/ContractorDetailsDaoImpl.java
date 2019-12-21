package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.controller.ClientPage;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class ContractorDetailsDaoImpl  implements ContractorDetailsDao{

	ContractorDetailsDto cdd=FactoryClass.getContractorDetailsDto();



	@Override
	public void addContractor() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				Scanner sc=new Scanner(System.in);
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertcontractor"))
				){	
			System.out.println("ENTER THE CONTRACT NO: ");
			cdd.setContractno(sc.nextInt());
			insert.setInt(1, cdd.getContractno());
			System.out.println("Enter the Customer Id: ");
			cdd.setCustomerid(sc.nextInt());
			insert.setInt(2, cdd.getCustomerid());
			System.out.println("Enter the Product Id: ");
			cdd.setProductid(sc.nextInt());
			insert.setInt(3, cdd.getProductid());
			System.out.println("Enter the Haulier Id: ");
			cdd.setHaulierid(sc.nextInt());
			sc.nextLine();
			insert.setInt(4, cdd.getHaulierid());
			System.out.println("Enter the Delivery Date: ");
			cdd.setDeliverydate(sc.nextLine());
			insert.setString(5, cdd.getDeliverydate());
			System.out.println("Enter the Delivery Day: ");
			cdd.setDeliveryday(sc.nextLine());
			insert.setString(6, cdd.getDeliveryday());
			System.out.println("Enter the Quantity: ");
			cdd.setQuantity(sc.nextLine());
			insert.setString(7, cdd.getQuantity());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nCONTRACTOR ADDED SUCCESSFULLY !!\n");
				ClientPage.contractorOperations();

			}
			else {
				System.out.println("WRONG INPUT ENTERED IN SOME FIELDS, PLEASE ENTER AGAIN PROPERLY !!");
				addContractor();
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


	}//add contractor end

	@Override
	public void viewContractorDetails() {


	}//view all contractor end


	@Override
	public void viewSingleContractorDetails() {
		//For loading the driver
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				Scanner sc=new Scanner(System.in);
				PreparedStatement viewsingle=conn.prepareStatement(prop.getProperty("viewsinglecontractor"))
				){	
			System.out.println("ENTER THE CONTRACT NO: ");
			cdd.setContractno(sc.nextInt());
			viewsingle.setInt(1, cdd.getContractno());
			ResultSet rs=viewsingle.executeQuery();
			System.out.println("\n<^^^^^^^^^^^CONTRACT DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CONTRACT NO: "+rs.getInt(1));
				System.out.println("CUSTOMER ID: "+rs.getInt(2));
				System.out.println("PRODUCT ID: "+rs.getInt(3));
				System.out.println("HAULIER ID: "+rs.getInt(4));
				System.out.println("DELIVERY DATE: "+rs.getString(5));
				System.out.println("DELIVERY DAY: "+rs.getString(6));
				System.out.println("QUANTITY : "+rs.getString(7));
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}	
			ClientPage.contractorOperations();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}//view single contractor end

	@Override
	public void deleteContractorDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				Scanner sc=new Scanner(System.in);
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deletecontractor"))
				){	
			System.out.println("ENTER THE CONTRACT NO: ");
			cdd.setContractno(sc.nextInt());
			delete.setInt(1, cdd.getContractno());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nCONTRACTOR DELETED SUCCESSFULLY !!\n");
				ClientPage.contractorOperations();

			}
			else {
				System.out.println("\nTHE CONTRACT NO THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
				addContractor();
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}



	}//delete contractor end




	@Override
	public void modifyContractorDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------------MODIFY CUSTOMER DETAILS---------------------");
		System.out.println("1.  MODIFY DELIVERY DATE: ");
		System.out.println("2.  MODIFY DELIVERY DAY: ");
		System.out.println("3.  MODIFY QUANTITY: ");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifydeliverydate"))
					){	
				System.out.println("ENTER THE CONTRACT NO: ");
				cdd.setContractno(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getContractno());
				System.out.println("ENTER THE DELIVERY DATE: ");
				cdd.setDeliverydate(sc.nextLine());
				modify.setString(1, cdd.getDeliverydate());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nDELIVERY DATE AND DAY MODIFIED SUCCESSFULLY !!\n");
					ClientPage.contractorOperations();
				}
				else {
					System.out.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !!\n");
					modifyContractorDetails();
				} 
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			break;
		case 2:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifydeliveryday"))
					){	
				System.out.println("ENTER THE CONTRACT NO: ");
				cdd.setContractno(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getContractno());
				System.out.println("ENTER THE DELIVERY DAY: ");
				cdd.setDeliveryday(sc.nextLine());
				modify.setString(1, cdd.getDeliveryday());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nDELIVERY DAY MODIFIED SUCCESSFULLY !!\n");
					ClientPage.contractorOperations();
				}
				else {
					System.out.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !!\n");
					modifyContractorDetails();
				} 
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}

			break;
		case 3:
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyquantity"))
					){	
				System.out.println("ENTER THE CONTRACT NO: ");
				cdd.setContractno(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getContractno());
				System.out.println("ENTER THE QUANTITY: ");
				cdd.setQuantity(sc.nextLine());
				modify.setString(1, cdd.getQuantity());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nQUANTITY MODIFIED SUCCESSFULLY !!\n");
					ClientPage.contractorOperations();
				}
				else {
					System.out.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT, PLEASE ENTER AGAIN !!\n");
					modifyContractorDetails();
				} 
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}


			break;
		default:
			break;
		}




	}//modify contractor end






}
