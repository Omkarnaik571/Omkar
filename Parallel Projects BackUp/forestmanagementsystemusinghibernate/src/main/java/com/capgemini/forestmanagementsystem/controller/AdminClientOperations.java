package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ClientDetailsDao;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.ClientService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminClientOperations {

	static Scanner sc=new Scanner(System.in);
	private static String[] args;
	
	public static void adminClientOperation(){
	
		PasswordValidator pv=new PasswordValidator();
		ClientDetailsDto cld=FactoryClass.getClientDetailsDto();
		ClientService cdd=FactoryClass.getClientDetailsServiceImpl();
		//		Scanner sc=new Scanner(System.in);
		while(true) {	
			System.out.println("--------------------CLIENT OPERATIONS------------------");
			System.out.println("1 ADD A CLIENT");
			System.out.println("2 DELETE A CLIENT");
			System.out.println("3 VIEW  CLIENT LISTS");
			System.out.println("4 VIEW  SINGLE CLIENT ");
			System.out.println("5 MODIFY CLIENT DETAILS");
			System.out.println("6 GO BACK TO HOME PAGE");
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
				System.out.println("ENTER THE CLIENT ID : ");
				char b='n';
				String b1=null;
				while(b=='n') {
					b1=sc.next();
					if(Validations.isNumber1(b1)) {
						b='x';
					}
					else {
						System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
					}
				}
				cld.setClientid(Integer.parseInt(b1));
				sc.nextLine();
				System.out.println("ENTER THE CLIENT NAME : ");
				String cname=null;
				char g='y';
				while(g=='y') {
					cname=sc.nextLine();
					if(Validations.isStringOnlyAlphabet(cname)) {
						g='n';
					}
					else {
						System.err.println("Customer Name can be of alphabets only !!");
					}
				}
				cld.setClientname(cname);
				System.out.println("ENTER THE CLIENT PASSWORD : ");
				char f='n';
				String f1=null;
				while(f=='n') {
					f1=sc.next();
					if( pv.validate(f1) ) {
						f='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}
				cld.setPassword(f1);
				try {
					boolean isAdded= cdd.addClient(cld);
				} catch (CustomExceptions e2) {
					e2.clientIdAlreadyExist();
				}
				break;
			case 2:
				System.out.println("ENTER THE CLIENT ID : ");
				char b12='n';
				String bb1=null;
				while(b12=='n') {
					bb1=sc.next();
					if(Validations.isNumber1(bb1)) {
						b12='x';
					}
					else {
						System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
					}
				}			
				cld.setClientid(Integer.parseInt(bb1));
				System.out.println("ENTER THE CLIENT PASSWORD : ");
				char f12='n';
				String ff1=null;
				while(f12=='n') {
					ff1=sc.next();
					if( pv.validate(ff1) ) {
						f12='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}

				cld.setPassword(ff1);
				boolean isDeleted= cdd.deleteClient(cld);
				break;
			case 3:
				boolean isViewAll=cdd.viewAllClient();
				break;
			case 4:
				System.out.println("ENTER THE CLIENT ID : ");
				char e12='n';
				String ee1=null;
				while(e12=='n') {
					ee1=sc.next();
					if(Validations.isNumber1(ee1)) {
						e12='x';
					}
					else {
						System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
					}
				}			
				cld.setClientid(Integer.parseInt(ee1));
				ClientDetailsDto isViewSingle=cdd.viewSingleClient(cld);
				if(isViewSingle == null) {
					System.err.println("\nThe client id that you have entered is not present !!\n");
				}
				else {
				System.out.println("\n---------CLIENT DETAILS------------------");
				System.out.println("Client Id : "+isViewSingle.getClientid());
				System.out.println("Client Name : "+isViewSingle.getClientname());
				System.out.println("Client Password : "+isViewSingle.getPassword());
				System.out.println("--------------------------------------------");
				}
				
				break;
			case 5:
				System.out.println("ENTER THE CLIENT ID : ");
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
				cld.setClientid(Integer.parseInt(e1));
				System.out.println("ENTER THE CLIENT PASSWORD : ");
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
				String pass=oldpwd;
				System.out.println("ENTER THE REVISED PASSWORD : ");
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

				cld.setPassword(newpwd);
				boolean isModified=cdd.modifyClient(cld,pass );
				break;
			case 6:
			     HomePage.main(args);
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}
		}//while loop end	
		
		
		
		
		
		
		
		
		
		
		
		
	}//end of method
	
	
	
}//end of class
