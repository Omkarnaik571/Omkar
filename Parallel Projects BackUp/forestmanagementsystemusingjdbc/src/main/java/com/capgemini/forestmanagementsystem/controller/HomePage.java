package com.capgemini.forestmanagementsystem.controller;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;

public class HomePage {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\n--------------------------WELCOME TO FOREST MANAGEMENT SYSTEM-------------------\n");
		System.out.println("\n--------SELECT YOUR CHOICES--------->>>>>>>\n");
		System.out.println("1. ADMIN PAGE");	
		System.out.println("2. CLIENT PAGE\n");
		System.out.println("3. SCHEDULER PAGE");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			//Admin page
			System.out.println("ENTER USERNAME FOR ADMIN: ");
			String usn=sc.next();
			System.out.println("ENTER PASSWORD FOR ADMIN: ");
			String pass=sc.next();
			if(usn.equals("admin")&&pass.equals("root")) {
				AdminPage.adminOperation();
			}
			else {
				System.out.println("\n # AUTHENTICATION FAILURE !! #\n");
				System.out.println("\n-------INVALID USERNAME OR PASSWORD------------ \n");
				main(args);
			}

			break;
		case 2:
            ClientDetailsDto cdd=FactoryClass.getClientDetailsDto();
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
					PreparedStatement stmt=conn.prepareStatement(prop.getProperty("findclient"))

					){	
				System.out.println("ENTER  CLIENT ID: ");
				cdd.setClientid(sc.nextInt());
				sc.nextLine();
				stmt.setInt(1, cdd.getClientid());
				int clientid=cdd.getClientid();
				System.out.println("ENTER  CLIENT PASSWORD:");
				String clientpassword=sc.nextLine();
				ResultSet rs=stmt.executeQuery();
				
				int fianlclientid=0;
				String finalclientpassword="";
				while(rs.next()) {
					fianlclientid=rs.getInt(1);
					finalclientpassword=rs.getString(3);
				}
				
				if( clientid == fianlclientid && clientpassword.equals(finalclientpassword) ) {
					ClientPage.clientOperation();
				}
				else {
					System.out.println("\nINVALID CLIENT USER ID AND PASSWORD..\n");
					main(args);
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			

			break;
		case 3:

			break;


		default:
			System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
			main(args);
			break;
		}








	}





}
