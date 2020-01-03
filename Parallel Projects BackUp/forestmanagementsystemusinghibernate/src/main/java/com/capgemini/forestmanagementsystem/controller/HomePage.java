package com.capgemini.forestmanagementsystem.controller;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder.In;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class HomePage {
 static	EntityManagerFactory emf=Persistence.createEntityManagerFactory("forestmanagement");
	public static void main(String[] args) {
		PasswordValidator pv=new PasswordValidator();
		
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("\n--------------------------WELCOME TO FOREST MANAGEMENT SYSTEM-------------------\n");
		System.out.println("1. ADMIN PAGE");	
		System.out.println("2. CLIENT PAGE");
		System.out.println("3. SCHEDULER PAGE");
		System.out.println("\nSELECT YOUR CHOICE--------->>>>>>>");
		char a='n';
		String choice=null;
		while(a=='n') {
			choice=sc.next();
			if(Validations.isNumber1(choice)) {
				a='x';
			}
			else {
				System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
			}
		}
		int ch=Integer.parseInt(choice);
		switch (ch) {
		case 1:
			//Admin page
			System.out.println("ENTER USERNAME FOR ADMIN: ");
			String usn=null;
			char o='n';
			while(o=='n') {
				usn=sc.next();
				if(Validations.isStringOnlyAlphabet(usn)) {
					o='x';
				}
				else {
					System.err.println("ClIENT USER NAME CAN BE OF ALPHABETS ONLY !!");
				}
			}//end of user name validation while
			System.out.println("ENTER PASSWORD FOR ADMIN: ");
			String pass=sc.next();
			
			if(usn.equals("admin")&&pass.equals("root")) {
				AdminPage.main(args);
			}
			else {
				System.err.println("\n # AUTHENTICATION FAILURE !! #\n");
				System.err.println("\nINVALID USERNAME OR PASSWORDn");
			}
			
			break;
		case 2:
			
			System.out.println("Enter the Client Id");
			char e='n';
			String e1=null;
			while(e=='n') {
				e1=sc.next();
				if(Validations.isNumber1(e1)) {
					e='x';
				}
				else {
					System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
				}
			}		
			
			int cid=Integer.parseInt(e1);
			System.out.println("Enter the client password ");
			char o1='n';
			String oldpwd=null;
			while(o1=='n') {
				oldpwd=sc.next();
				if( pv.validate(oldpwd) ) {
					o1='x';
				}
				else {
					System.err.println("Password must contains one digit from 0-9 ");
					System.err.println("one lowercase character, one uppercase character ");
					System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
				}
			}
			
			
			String pwd=oldpwd;
			EntityManager em=emf.createEntityManager();
		   ClientDetailsDto cdetails=em.find(ClientDetailsDto.class,cid);
			try {
		   if(pwd.equals(cdetails.getPassword())) {
				System.out.println("Client Found..");
				ClientPage.main(args);
			}
			else {
				System.err.println("\nINVALID CLIENT ID AND PASSWORD\n");
			}
			}//end of try
			catch (Exception e2) {
				System.err.println("\nINVALID CLIENT ID AND PASSWORD !! \n");
				// TODO: handle exception
			}
            
			break;
		case 3:
			System.out.println("Enter the Scheduler Id");
			char f='n';
			String f1=null;
			while(f=='n') {
				f1=sc.next();
				if(Validations.isNumber1(f1)) {
					f='x';
				}
				else {
					System.err.println("ENTER THE SCHEDULER ID IN INTEGER VALUES !!");
				}
			}		
			
			int sid=Integer.parseInt(f1);
			System.out.println("Enter the Scheduler password ");
			char o2='n';
			String newpwd=null;
			while(o2=='n') {
				newpwd=sc.next();
				if( pv.validate(newpwd) ) {
					o2='x';
				}
				else {
					System.err.println("Password must contains one digit from 0-9 ");
					System.err.println("one lowercase character, one uppercase character ");
					System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
				}
			}
			
			String spwd=newpwd;
			EntityManager entityManager=emf.createEntityManager();
		   SchedulerDetailsDto sdt=entityManager.find(SchedulerDetailsDto.class,sid);
			try {
		   if(spwd.equals(sdt.getPassword())) {
				System.out.println("Scheduler Found..");
				SchedulerPage.main(args);
			}
			else {
				System.err.println("\nINVALID SCHEDULER ID AND PASSWORD\n");
			}
			}//end of try 
			catch (Exception e2) {
				System.err.println("\nINVALID SCHEDULER ID AND PASSWORD !! \n");
				// TODO: handle exception
			}
			break;
		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
			break;
		}

		}//end of while
	}//end of method





}//end of class
