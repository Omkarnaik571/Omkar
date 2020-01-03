package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.ContractService;
import com.capgemini.forestmanagementsystem.validations.Validations;



public class SchedulerContractOperations {
   
	static Scanner sc=new Scanner(System.in);
	
	public static void schedulerSchedulerOperation(){
	
		ContractorDetailsDto cdd=FactoryClass.getContractorDetailsDto();
		ContractService cs=FactoryClass.getContractDetailsServiceImpl();
		while(true) {
			System.out.println("--------------------CONTRACT OPERATIONS------------------");
			System.out.println("1 ADD A CONTRACTOR");
			System.out.println("2 DELETE A CONTRACTOR");
			System.out.println("3 VIEW  CONTRACTOR");
			System.out.println("4 VIEW  ALL CONTRACTOR");
			System.out.println("5 MODIFY CONTRACT DETAILS");
			System.out.println("6 GO BACK TO CLIENT PAGE");
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
				System.out.println("ENTER THE CONTRACT NO: ");
				char b='n';
				String b1=null;
				while(b=='n') {
					b1=sc.next();
					if(Validations.isNumber1(b1)) {
						b='x';
					}
					else {
						System.err.println("Enter the contract number in integer value !!");
					}
				}
				cdd.setContractno(Integer.parseUnsignedInt(b1));
				System.out.println("Enter the Customer Id: ");
				char c='n';
				String c1=null;
				while(c=='n') {
					c1=sc.next();
					if(Validations.isNumber1(c1)) {
						c='x';
					}
					else {
						System.err.println("Enter the customer id in integer value !!");
					}
				}
				cdd.setCustomerid(Integer.parseUnsignedInt(c1));
				System.out.println("Enter the Product Id: ");
				char d='n';
				String d1=null;
				while(d=='n') {
					d1=sc.next();
					if(Validations.isNumber1(d1)) {
						d='x';
					}
					else {
						System.err.println("Enter the product id in integer value !!");
					}
				}
				cdd.setProductid(Integer.parseInt(d1));
				System.out.println("Enter the Haulier Id: ");
				char f='n';
				String f1=null;
				while(f=='n') {
					f1=sc.next();
					if(Validations.isNumber1(f1)) {
						f='x';
					}
					else {
						System.err.println("Enter the haulier id in integer value !!");
					}
				}
				cdd.setHaulierid(Integer.parseUnsignedInt(f1));
				sc.nextLine();
				System.out.println("Enter the Delivery Date: ");
				String ddate=null;
				char z='y';
				while(z=='y') {
					ddate=sc.next();
					if( Validations.isValidDate(ddate)) {
						System.err.println("\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
					}
					else {
						z='n';
					}
				}
				cdd.setDeliverydate(ddate);
				System.out.println("Enter the Delivery Day: ");
				String day=null;
				char g='y';
				while(g=='y') {
					day=sc.next();
					if(Validations.isValidDay(day)) {
						g='n';
					}
					else {
						System.err.println("Please enter a day according to the calender (i.e Sunday, Monday) !!");
					}
				}
				cdd.setDeliveryday(day);
				System.out.println("Enter the Quantity:(Enter In Terms Of Kg) !! ");
				//			sc.nextLine();
				cdd.setQuantity(sc.next());
				try {
					boolean isAdded=cs.addContractor(cdd);
				} catch (ContractCustomException e) {
					e.primarykeyviolation();
				}
				
				break;
			case 2:
				System.out.println("ENTER THE CONTRACT NO: ");
				char i='n';
				String i1=null;
				while(i=='n') {
					i1=sc.next();
					if(Validations.isNumber1(i1)) {
						i='x';
					}
					else {
						System.err.println("Enter the Contractor number in integer value !!");
					}
				}
				cdd.setContractno(Integer.parseInt(i1));
				boolean isDeleted=cs.deleteContractorDetails(cdd);
				break;
			case 3:
				System.out.println("ENTER THE CONTRACT NO: ");
				char k='n';
				String k1=null;
				while(k=='n') {
					k1=sc.next();
					if(Validations.isNumber1(k1)) {
						k='x';
					}
					else {
						System.err.println("Enter the Contractor number in integer value !!");
					}
				}
				cdd.setContractno(Integer.parseInt(k1));
				ContractorDetailsDto isViewSingle=cs.viewSingleContractorDetails(cdd);
				if(isViewSingle == null) {
					System.err.println("\nThe contract number that you have entered is not present !!\n");
				}
				else {
				System.out.println("\n---------CONTRACT DETAILS------------------");
				System.out.println("Contract No : "+isViewSingle.getContractno());
				System.out.println("Customer Id : "+isViewSingle.getCustomerid());
				System.out.println("Product Id : "+isViewSingle.getProductid());
				System.out.println("Haulier Id : "+isViewSingle.getHaulierid());
				System.out.println("Delivery Date: "+isViewSingle.getDeliverydate());
				System.out.println("Delivery Day : "+isViewSingle.getDeliveryday());
				System.out.println("Quantity : "+isViewSingle.getQuantity());
				System.out.println("Contract Status : "+isViewSingle.getContractstatus());
				System.out.println("--------------------------------------------");
				}
				
				break;
			case 4:
				boolean isViewAll=cs.viewContractorDetails();
				break;
			case 5:
				System.out.println("--------------------MODIFY CONTRACT DETAILS---------------------");
				System.out.println("1.  MODIFY DELIVERY DATE: ");
				System.out.println("2.  MODIFY DELIVERY DAY: ");
				System.out.println("3.  MODIFY QUANTITY: ");
				System.out.println("4.  MODIFY CONTRACT STATUS: ");
				char a1='n';
				String choice1=null;
				while(a1=='n') {
					choice1=sc.next();
					if(Validations.isNumber1(choice1)) {
						a1='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}
				int option=Integer.parseInt(choice1);
				boolean isModified=false;
				switch (option) {
				case 1:
					System.out.println("ENTER THE CONTRACT NO: ");
					char b11='n';
					String bb1=null;
					while(b11=='n') {
						bb1=sc.next();
						if(Validations.isNumber1(bb1)) {
							b11='x';
						}
						else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractno(Integer.parseInt(bb1));
					sc.nextLine();
					System.out.println("ENTER THE REVISED DELIVERY DATE: ");
					String ddate2=null;
					char z2='y';
					while(z2=='y') {
						ddate2=sc.next();
						if( Validations.isValidDate(ddate2)) {
							System.err.println("\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
						}
						else {
							z2='n';
						}
					}
					cdd.setDeliverydate(ddate2);
					isModified=cs.modifyContractorDetails(cdd, option);
					break;
				case 2:
					System.out.println("ENTER THE CONTRACT NO: ");
					char c11='n';
					String cc1=null;
					while(c11=='n') {
						cc1=sc.next();
						if(Validations.isNumber1(cc1)) {
							c11='x';
						}
						else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractno(Integer.parseInt(cc1));
					sc.nextLine();
					System.out.println("ENTER THE REVISED DELIVERY DAY: ");
					String day2=null;
					char g2='y';
					while(g2=='y') {
						day2=sc.next();
						if(Validations.isValidDay(day2)) {
							g2='n';
						}
						else {
							System.err.println("Please enter a day according to the calender (i.e Sunday, Monday) !!");
						}
					}

					cdd.setDeliveryday(day2);
					isModified=cs.modifyContractorDetails(cdd, option);
					break;
				case 3:
					System.out.println("ENTER THE CONTRACT NO: ");
					char d11='n';
					String dd1=null;
					while(d11=='n') {
						dd1=sc.next();
						if(Validations.isNumber1(dd1)) {
							d11='x';
						}
						else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractno(Integer.parseInt(dd1));
					sc.nextLine();
					System.out.println("ENTER THE QUANTITY: (Enter In Terms Of Kg) !! ");
					cdd.setQuantity(sc.nextLine());
					isModified=cs.modifyContractorDetails(cdd, option);
					break;
				case 4:
					System.out.println("ENTER THE CONTRACT NO: ");
					char e11='n';
					String ee1=null;
					while(e11=='n') {
						ee1=sc.next();
						if(Validations.isNumber1(ee1)) {
							e11='x';
						}
						else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractno(Integer.parseInt(ee1));
					System.out.println("ENTER THE CONTRACT STATUS !! ");
					String cstatus=null;
					char h2='y';
					while(h2=='y') {
						cstatus=sc.next();
						if(Validations.isStringOnlyAlphabet(cstatus)) {
							h2='n';
						}
						else {
							System.err.println("Please enter a day according to the calender (i.e Sunday, Monday) !!");
						}
					}	
					cdd.setContractstatus(cstatus);
					isModified=cs.modifyContractorDetails(cdd, option);
					break;

				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
					break;
				}

				break;
			case 6:
				
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}


		}//end of while loop
		
		
		
		
		
		
		
	
	}//end of method
	
}//end of class
