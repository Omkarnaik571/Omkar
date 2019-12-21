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
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.mysql.jdbc.Statement;

public class ProductDaoImpl implements ProductDao {
	ProductDetailsDto pdd=FactoryClass.getProductDetailsDto();

	@Override
	public boolean addProduct() {
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
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertproduct"))
				){	
			System.out.println("ENTER PRODUCT ID: ");
			 pdd.setProductid(sc.nextInt());
			 sc.nextLine();
			 System.out.println("ENTER PRODUCT NAME:");
				pdd.setProductname(sc.nextLine());
			 insert.setInt(1, pdd.getProductid());
			insert.setString(2, pdd.getProductname());
			 int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nPRODUCT ADDED SUCCESSFULLY !!\n");
				return true;
				
			}
			else {
				System.out.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA AGAIN PROPERLY !!\n");
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return false;
	}//end of addProduct()

	@Override
	public boolean deleteProduct() {
		
		return false;
	}// end of deleteProduct()

	@Override
	public boolean modifyProduct() {
		
		return false;
	}// end of modifyProduct()

	@Override
	public void viewAllProduct() {
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
				java.sql.Statement stmt=conn.createStatement()
				){	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallproduct"));
			System.out.println("\n<^^^^^^PRODUCT DETAILS^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("PRODUCT ID : "+rs.getInt(1));
				System.out.println("PRODUCT NAME : "+rs.getString(2));
				System.out.println("--------------------------------------------------------------------------");
			}
			System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>\n");
			ClientPage.productOperations();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}// end of view allProduct()

	@Override
	public void viewParticularProduct() {
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
				PreparedStatement view=conn.prepareStatement(prop.getProperty("viewsingleproduct"))
				){	
			System.out.println("ENTER PRODUCT ID: ");
			 pdd.setProductid(sc.nextInt());
			 view.setInt(1, pdd.getProductid());
			ResultSet rs=view.executeQuery();
			System.out.println("\n<^^^^^^PRODUCT DETAILS^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("PRODUCT ID : "+rs.getInt(1));
				System.out.println("PRODUCT NAME : "+rs.getString(2));
				System.out.println("---------------------------------------------------------------------");
			}
			System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>\n");
			ClientPage.productOperations();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}// end of ParticularProduct()

	
	
	
}
