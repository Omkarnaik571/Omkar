package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class LandDaoImpl implements LandDao {
    LandDetailsDto ldd=FactoryClass.getLandDetailsDto();
	
	@Override
	public void addLand() {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertlanddetails"))
				){	
			System.out.println("ENTER THE PLOT NUMBER : ");
			ldd.setPlotnumber(sc.nextInt());
			sc.nextLine();
			insert.setInt(1, ldd.getPlotnumber());
			System.out.println("ENTER THE ACQUIRED DATE : ");
			ldd.setAcquireddate(sc.nextLine());
			insert.setString(2, ldd.getAcquireddate());
			System.out.println("ENTER THE LAND VALUE : ");
			ldd.setLandvalue(sc.nextLine());
			insert.setString(3, ldd.getLandvalue());
			System.out.println("ENTER THE LOCATION : ");
			ldd.setLocation(sc.nextLine());
			insert.setString(4, ldd.getLocation());
			int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nLAND ADDED SUCCESSFULLY !!\n");
				AdminPage.landOperations();

			}
			else {
				System.out.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				addLand();
			} 
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		
	}
	//add land end..

	@Override
	public void deleteLand() {
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
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deletelanddetails"))
				){
			System.out.println("ENTER THE PLOT NUMBER : ");
			ldd.setPlotnumber(sc.nextInt());
		    delete.setInt(1, ldd.getPlotnumber());
		    int result=delete.executeUpdate();
			if(result>0) {
				System.out.println("\nCLIENT DELETED SUCCESSFULLY !!\n");
				AdminPage.landOperations();

			}
			else {
				System.out.println("\nINCORRECT CLIENT ID AND PASSWORD,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				deleteLand();
			} 
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
	// delete land end..
	
	@Override
	public void modifyLand() {
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
				PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifylanddetails"));
						PreparedStatement modifylandvalue=conn.prepareStatement(prop.getProperty("modifylandvalue"))	
				){
			System.out.println("ENTER THE PLOT NUMBER : ");
			ldd.setPlotnumber(sc.nextInt());
		    modify.setInt(2, ldd.getPlotnumber());
		    sc.nextLine();
			System.out.println("ENTER THE  REVISED ACQUIRED DATE : ");
			ldd.setAcquireddate(sc.nextLine());
			modify.setString(1, ldd.getAcquireddate());
			int result=modify.executeUpdate();
			modifylandvalue.setInt(2, ldd.getPlotnumber());
			System.out.println("ENTER THE REVISED LAND VALUE : ");
			ldd.setLandvalue(sc.nextLine());
			modifylandvalue.setString(1, ldd.getLandvalue());
			int result1=modifylandvalue.executeUpdate();
			if(result>0 && result1>0) {
				System.out.println("\nLAND DETAILS MODIFIED SUCCESSFULLY !!\n");
				AdminPage.landOperations();

			}
			else {
				System.out.println("\nINCORRECT CLIENT ID AND PASSWORD,   PLEASE INSERT DATA AGAIN PROPERLY !!\n");
				modifyLand();
			} 
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
	// modify land end

	@Override
	public void viewAllLand() {
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
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewalllanddetails"));
			System.out.println("\n<^^^^^^^^^^^LAND DETAILS^^^^^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("PLOT NUMBER : "+rs.getInt(1));
				System.out.println("ACQUIRED DATE : "+rs.getString(2));
				System.out.println("LAND VALUE : "+rs.getString(3));
				System.out.println("LOCATION : "+rs.getString(4));
				System.out.println("------------------------------------------------------------------------------");
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			AdminPage.landOperations();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	// view all land end..

}
