package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class CustomerDetailsDaoImpl implements CustomerDetailsDao {
	CustomerDetailsDto cdd=FactoryClass.getCustomerDetailsDto();


	@Override
	public void addCustomer() {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertcustomer"))
				){	
			System.out.println("ENTER THE CUSTOMER ID: ");
			cdd.setCustomerid(sc.nextInt());
			sc.nextLine();
			insert.setInt(1, cdd.getCustomerid());
			System.out.println("ENTER THE CUSTOMER NAME: ");
			cdd.setCustomername(sc.nextLine());
			insert.setString(2, cdd.getCustomername());
			System.out.println("ENTER THE STREET ADDRESS 1: ");
			cdd.setStreetaddress1(sc.nextLine());
			insert.setString(3, cdd.getStreetaddress1());
			System.out.println("ENTER THE STREET ADDRESS 2: ");
			cdd.setStreetaddress2(sc.nextLine());
			insert.setString(4, cdd.getStreetaddress2());
			System.out.println("ENTER THE TOWN: ");
			cdd.setTown(sc.nextLine());
			insert.setString(5, cdd.getTown());
			System.out.println("ENTER THE POSTAL CODE: ");
			cdd.setPostalcode(sc.nextInt());
			sc.nextLine();
			insert.setInt(6, cdd.getPostalcode());
			System.out.println("ENTER THE E-MAIL: ");
			cdd.setEmail(sc.nextLine());
			insert.setString(7, cdd.getEmail());
			System.out.println("ENTER THE TELEPHONE NUMBER: ");
			cdd.setTelephoneno(sc.nextLong());
			sc.nextLine();
			insert.setLong(8, cdd.getTelephoneno());
			System.out.println("ENTER THE PASSWORD: ");
			cdd.setPassword(sc.nextLine());
			insert.setString(9, cdd.getPassword());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nCUSTOMER ADDED SUCCESSFULLY !!\n");
				AdminPage.customerOperations();

			}
			else {
				System.out.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				addCustomer();
			} 


		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
	//add customer end..

	@Override
	public void viewCustomerDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
				java.sql.Statement stmt= conn.createStatement();

				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallcustomer"));
			System.out.println("\n<^^^^^^^^^^^CUSTOMER DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CUSTOMER ID: "+rs.getInt(1));
				System.out.println("Customer NAME: "+rs.getString(2));
				System.out.println("STREET ADDRESS 1: "+rs.getString(3));
				System.out.println("STREET ADDRESS 2: "+rs.getString(4));
				System.out.println("TOWN: "+rs.getString(5));
				System.out.println("POSTAL CODE: "+rs.getInt(6));
				System.out.println("E-MAIL: "+rs.getString(7));
				System.out.println("TELEPHONE NUMBER: "+rs.getLong(8));
				System.out.println("PASSWORD : "+rs.getString(9));
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}	
			AdminPage.customerOperations();

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}



	}
	//view customer details end..
	@Override
	public void viewSingleCustomerDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("viewsinglecustomer"))

				){	
			System.out.println("ENTER THE CUSTOMER ID: ");
			cdd.setCustomerid(sc.nextInt());
			pstmt.setInt(1, cdd.getCustomerid());
			ResultSet rs=pstmt.executeQuery();
			System.out.println("\n<^^^^^^^^^^^CUSTOMER DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CUSTOMER ID: "+rs.getInt(1));
				System.out.println("Customer NAME: "+rs.getString(2));
				System.out.println("STREET ADDRESS 1: "+rs.getString(3));
				System.out.println("STREET ADDRESS 2: "+rs.getString(4));
				System.out.println("TOWN: "+rs.getString(5));
				System.out.println("POSTAL CODE: "+rs.getInt(6));
				System.out.println("E-MAIL: "+rs.getString(7));
				System.out.println("TELEPHONE NUMBER: "+rs.getLong(8));
				System.out.println("PASSWORD : "+rs.getString(9));
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			}	
			AdminPage.customerOperations();


		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}



	}
	//view single customer deatails end..


	@Override
	public void deleteCustomerDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deletecustomer"))
				){	
			System.out.println("ENTER THE CUSTOMER ID: ");
			cdd.setCustomerid(sc.nextInt());
			sc.nextLine();
			delete.setInt(1, cdd.getCustomerid());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nCUSTOMER DELETED SUCCESSFULLY !!\n");
				AdminPage.customerOperations();

			}
			else {
				System.out.println("\nINCORRECT CUSTOMER ID    PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				deleteCustomerDetails();
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
	//delete customer details end..
	@Override
	public void modifyCustomerDetails() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------------MODIFY CUSTOMER DETAILS---------------------");
		System.out.println("1.  STREET ADDRESS 1: ");
		System.out.println("2.  STREET ADDRESS 2: ");
		System.out.println("3.  TOWN: ");
		System.out.println("4.  POSTAL CODE: ");
		System.out.println("5.  E-MAIL: ");
		System.out.println("6.  TELEPHONE NUMBER: ");
		System.out.println("7.  PASSWORD: ");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifystreetaddress1"))
					){	
				System.out.println("ENTER THE CUSTOMER ID: ");
				cdd.setCustomerid(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getCustomerid());
				System.out.println("1. ENTER THE  REVISED STREET ADDRESS 1: ");
				cdd.setStreetaddress1(sc.nextLine());
				modify.setString(1, cdd.getStreetaddress1());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nSTREET ADDRESS 1 MODIFIED SUCCESSFULLY !!\n");
					AdminPage.customerOperations();

				}
				else {
					System.out.println("\nINCORRECT CUSTOMER ID ,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					modifyCustomerDetails();
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
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifystreetaddress2"))
					){	
				System.out.println("ENTER THE CUSTOMER ID: ");
				cdd.setCustomerid(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getCustomerid());
				System.out.println("1. ENTER THE  REVISED STREET ADDRESS 2: ");
				cdd.setStreetaddress2(sc.nextLine());
				modify.setString(1, cdd.getStreetaddress2());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nSTREET ADDRESS 2 MODIFIED SUCCESSFULLY !!\n");
					AdminPage.customerOperations();

				}
				else {
					System.out.println("\nINCORRECT CUSTOMER ID ,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					modifyCustomerDetails();
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
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifytown"))
					){	
				System.out.println("ENTER THE CUSTOMER ID: ");
				cdd.setCustomerid(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getCustomerid());
				System.out.println("1. ENTER THE  REVISED TOWN: ");
				cdd.setTown(sc.nextLine());
				modify.setString(1, cdd.getTown());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nTOWN MODIFIED SUCCESSFULLY !!\n");
					AdminPage.customerOperations();

				}
				else {
					System.out.println("\nINCORRECT CUSTOMER ID ,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					modifyCustomerDetails();
				} 
				
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
			break;
		case 4:
			
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifypostalcode"))
					){	
				System.out.println("ENTER THE CUSTOMER ID: ");
				cdd.setCustomerid(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getCustomerid());
				System.out.println("1. ENTER THE  REVISED POSTAL CODE: ");
				cdd.setPostalcode(sc.nextInt());
				sc.nextLine();
				modify.setInt(1, cdd.getPostalcode());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nPOSTAL CODE MODIFIED SUCCESSFULLY !!\n");
					AdminPage.customerOperations();

				}
				else {
					System.out.println("\nINCORRECT CUSTOMER ID ,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					modifyCustomerDetails();
				} 
				
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
			
			break;
		case 5:
				
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyemail"))
					){	
				System.out.println("ENTER THE CUSTOMER ID: ");
				cdd.setCustomerid(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getCustomerid());
				System.out.println("1. ENTER THE  REVISED E-MAIL: ");
				cdd.setEmail(sc.nextLine());
				modify.setString(1, cdd.getEmail());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nE-MAIL CODE MODIFIED SUCCESSFULLY !!\n");
					AdminPage.customerOperations();

				}
				else {
					System.out.println("\nINCORRECT CUSTOMER ID ,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					modifyCustomerDetails();
				} 
				
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			break;
		case 6:
			
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifytelephoneno"))
					){	
				System.out.println("ENTER THE CUSTOMER ID: ");
				cdd.setCustomerid(sc.nextInt());
				modify.setInt(2, cdd.getCustomerid());
				System.out.println("1. ENTER THE  REVISED TELEPHONE NUMBER: ");
				cdd.setTelephoneno(sc.nextLong());
				sc.nextLine();
				modify.setLong(1, cdd.getTelephoneno());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nTELEPHONE NUMBER CODE MODIFIED SUCCESSFULLY !!\n");
					AdminPage.customerOperations();

				}
				else {
					System.out.println("\nINCORRECT CUSTOMER ID ,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					modifyCustomerDetails();
				} 
				
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			
			break;
		case 7:
			
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifypasswordcustomer1"))
					){	
				System.out.println("ENTER THE CUSTOMER ID: ");
				cdd.setCustomerid(sc.nextInt());
				sc.nextLine();
				modify.setInt(2, cdd.getCustomerid());
				System.out.println("1. ENTER THE  REVISED PASSWORD: ");
				cdd.setPassword(sc.nextLine());
				modify.setString(1, cdd.getPassword());
				int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nPASSWORD MODIFIED SUCCESSFULLY !!\n");
					AdminPage.customerOperations();

				}
				else {
					System.out.println("\nINCORRECT CUSTOMER ID ,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
					modifyCustomerDetails();
				} 
				
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
				
			break;
		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			modifyCustomerDetails();
			break;
		}
	}
	//modify customer details end..

}
