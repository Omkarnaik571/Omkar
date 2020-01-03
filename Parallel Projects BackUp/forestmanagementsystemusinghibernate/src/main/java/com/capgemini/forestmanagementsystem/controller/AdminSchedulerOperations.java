package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.capgemini.forestmanagementsystem.dao.SchedulerDetailsDao;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.SchedulerService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminSchedulerOperations {

 static Scanner sc=new Scanner(System.in);
private static String[] args;
	
	
public static void adminSchedulerOperation(){
	
	PasswordValidator pv=new PasswordValidator();
	SchedulerDetailsDto cld=FactoryClass.getSchedulerDetailsDto();
	SchedulerService cdd=FactoryClass.getSchedulerDetailsServiceImpl();		

	while(true) {	
		System.out.println("--------------------SCHEDULER OPERATIONS------------------");
		System.out.println("1 ADD A SCHEDULER");
		System.out.println("2 DELETE A SCHEDULER");
		System.out.println("3 VIEW  SCHEDULER LISTS");
		System.out.println("4 VIEW  PARTICULAR SCHEDULER ");
		System.out.println("5 MODIFY SCHEDULER DETAILS");
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
			System.out.println("ENTER THE SCHEDULER ID : ");
			char b='n';
			String b1=null;
			while(b=='n') {
				b1=sc.next();
				if(Validations.isNumber1(b1)) {
					b='x';
				}
				else {
					System.err.println("ENTER THE SCHEDULER ID IN INTEGER VALUES !!");
				}
			}
			cld.setSchedulerid(Integer.parseInt(b1));
			sc.nextLine();
			System.out.println("ENTER THE SCHEDULER NAME : ");
			String cname=null;
			char g='y';
			while(g=='y') {
				cname=sc.nextLine();
				if(Validations.isStringOnlyAlphabet(cname)) {
					g='n';
				}
				else {
					System.err.println("SCHEDULER Name can be of alphabets only !!");
				}
			}
			cld.setSchedulername(cname);
			System.out.println("ENTER THE SCHEDULER PASSWORD : ");
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
				boolean isAdded= cdd.addScheduler(cld);
			} catch (CustomExceptions e) {
				
				e.schedulerIdAlreadyExist();
			}
			break;
		case 2:
			System.out.println("ENTER THE SCHEDULER ID : ");
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
			cld.setSchedulerid(Integer.parseInt(bb1));
			boolean isDeleted= cdd.deleteScheduler(cld);
			break;
		case 3:
			boolean isViewAll=cdd.viewAllScheduler();
			break;
		case 4:
			System.out.println("ENTER SCHEDULER ID: ");
			char t='n';
			String t1=null;
			while(t=='n') {
				t1=sc.next();
				if(Validations.isNumber1(t1)) {
					t='x';
				}
				else {
					System.err.println("Enter the Product id in integer value, and length should be less than 10 digits !!");
				}
			}
			cld.setSchedulerid(Integer.parseInt(t1));
			SchedulerDetailsDto isViewSingle=cdd.viewSingleScheduler(cld);
			System.out.println(isViewSingle);
			if(isViewSingle == null) {
				System.err.println("\nThe Scheduler id that you have entered is not present !!\n");
			}
			else {
			System.out.println("\n---------SCHEDULER DETAILS------------------");
			System.out.println("Scheduler ID : "+isViewSingle.getSchedulerid());
			System.out.println("Scheduler Name : "+isViewSingle.getSchedulername());
			System.out.println("Scheduler Password : "+isViewSingle.getPassword());
			System.out.println("--------------------------------------------");
			}
			
			break;
		case 5:
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
