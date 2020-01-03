package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.SchedulerService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class SchedulerPage {

	static Scanner sc=new Scanner(System.in);
	private static String[] args;

	public static void main(String[] args) {
		PasswordValidator pv=new PasswordValidator();
		SchedulerDetailsDto cld=FactoryClass.getSchedulerDetailsDto();
		SchedulerService cdd=FactoryClass.getSchedulerDetailsServiceImpl();	
		
		while(true) {
		System.out.println("\n------------------------SCHEDULER PAGE-----------------------------\n");
		System.out.println("1 FOR CONTRACTOR  OPEARTION");
		System.out.println("2 FOR PASSWORD MODIFICATION");
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
             SchedulerContractOperations.schedulerSchedulerOperation();
			break;
		case 2:
			System.out.println("ENTER THE SCHEDULER ID : ");
			char e='n';
			String e1=null;
			while(e=='n') {
				e1=sc.next();
				if(Validations.isNumber1(e1)) {
					e='x';
				}
				else {
					System.err.println("ENTER THE SCHEDULER ID IN INTEGER VALUES !!");
				}
			}		
			cld.setSchedulerid(Integer.parseInt(e1));
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
			boolean isModified=cdd.modifyScheduler(cld);
			
			
			
			break;

		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION\n");
			break;
		}

		}//end of while loop
		
	}//main method end
	
	



}//end of class
