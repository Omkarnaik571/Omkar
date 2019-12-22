package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

public class HomePage {
	public static void main(String[] args) {
		System.out.println("\n--------------------------FOREST MANAGEMENT SYSTEM-------------------\n");
		System.out.println("1 Admin Page");
		System.out.println("2 Client Page");
		Scanner sc=new Scanner(System.in);
		int page=sc.nextInt();
		sc.nextLine();
		switch (page) {
		case 1:
           AdminPage.adminPage();
			break;
		case 2:
           ClientPage.clientPage();
			break;
		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION \n");
			main(args);
			break;
		}



	}



}
