package com.capgemini.forestmanagementsystem.controller;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.ClientService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class ClientPage {

	static Scanner sc=new Scanner(System.in);


	private static String[] args;

	public static void main(String[] args) {
		PasswordValidator pv=new PasswordValidator();
		ClientDetailsDto cld=FactoryClass.getClientDetailsDto();
		ClientService cdd=FactoryClass.getClientDetailsServiceImpl();
		//		 Scanner sc1=new Scanner(System.in);
		while(true) {
			System.out.println("\n------------------------CLIENT PAGE-----------------------------\n");
			System.out.println("1 FOR CONTRACTOR  OPEARTION");
			System.out.println("2 FOR PRODUCT  OPEARTION");
			System.out.println("3 MODIFY PASSWORD");
			System.out.println("4 FOR GOING BACK TO HOME PAGE");
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
				ClientContractOperations.clientContractOperation();
				break;
			case 2:
				ClientProductOperations.clientProductOperation();
				break;
			case 3:
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
			case 4:
				HomePage.main(args);
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........");
				break;
			}
		}//end of while loop

	}


	
}
