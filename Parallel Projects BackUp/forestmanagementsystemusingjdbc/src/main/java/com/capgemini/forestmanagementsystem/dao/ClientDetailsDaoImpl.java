package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class ClientDetailsDaoImpl implements ClientDetailsDao {
	ClientDetailsDto cld=FactoryClass.getClientDetailsDto();



	@Override
	public void addClient() {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertclientdetails"))
				){	
			System.out.println("ENTER THE CLIENT ID : ");
			cld.setClientid(sc.nextInt());
			sc.nextLine();
			insert.setInt(1, cld.getClientid());
			System.out.println("ENTER THE CLIENT NAME : ");
			cld.setClientname(sc.nextLine());
			insert.setString(2, cld.getClientname());
			System.out.println("ENTER THE CLIENT PASSWORD : ");
			cld.setPassword(sc.nextLine());
			insert.setString(3, cld.getPassword());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nCLIENT ADDED SUCCESSFULLY !!\n");
				AdminPage.clientOperations();

			}
			else {
				System.out.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				addClient();
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
	//add client end..


	@Override
	public void deleteClient() {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deleteclientdetails"))
				){	
			System.out.println("ENTER THE CLIENT ID : ");
			cld.setClientid(sc.nextInt());
			sc.nextLine();
			delete.setInt(1, cld.getClientid());
			System.out.println("ENTER THE CLIENT PASSWORD : ");
			cld.setPassword(sc.nextLine());
			delete.setString(2, cld.getPassword());
			int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nCLIENT DELETED SUCCESSFULLY !!\n");
				AdminPage.clientOperations();

			}
			else {
				System.out.println("\nINCORRECT CLIENT ID AND PASSWORD,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				deleteClient();
			} 



		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}



	}
	//delete client details end....



	@Override
	public void modifyClient() {
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
				PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifypassword"))
						
				){	
			System.out.println("ENTER THE CLIENT ID : ");
			cld.setClientid(sc.nextInt());
			sc.nextLine();
			modify.setInt(2, cld.getClientid());
			System.out.println("ENTER THE CLIENT PASSWORD : ");
			cld.setPassword(sc.nextLine());
			modify.setString(3, cld.getPassword());
			System.out.println("ENTER THE REVISED PASSWORD : ");
			cld.setPassword(sc.nextLine());
			modify.setString(1, cld.getPassword());
			int result=modify.executeUpdate();
			if(result>0) {
				System.out.println("\nPASSWORD MODIFIED SUCCESSFULLY !!\n");
				AdminPage.clientOperations();

			}
			else {
				System.out.println("\nINCORRECT CLIENT ID AND PASSWORD,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				modifyClient();
			} 
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		


	}
	//modify client end


	@Override
	public void viewAllClient() {
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
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallclientdetails"));
			System.out.println("\n<^^^^^^^^^^^CLIENT DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("CLIENT ID : "+rs.getInt(1));
				System.out.println("CLIENT NAME : "+rs.getString(2));
				System.out.println("PASSWORD : "+rs.getString(3));
				System.out.println("------------------------------------------------------------------------------");
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			AdminPage.clientOperations();

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}





	}



}
