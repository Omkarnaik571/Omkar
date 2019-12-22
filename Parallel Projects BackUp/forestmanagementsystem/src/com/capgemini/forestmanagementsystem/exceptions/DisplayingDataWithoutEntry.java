package com.capgemini.forestmanagementsystem.exceptions;

public class DisplayingDataWithoutEntry extends RuntimeException{

	
	public void dataWithoutEntryForClient() {
		System.err.println("\nTHERE ARE NO CLIENTS IN THE DATA BASE,  INSERT DATA FIRST  ....\n");
	}
	
	public void dataWithoutEntryForProduct() {
		System.err.println("\nTHERE IS NO PRODUCT DATA IN THE DATA BASE,  INSERT DATA FIRST  ....\n");
	}
	
	public void dataWithoutEntryForCustomer() {
		System.err.println("\nTHERE IS NO CUSTOMER DATA IN THE DATA BASE,  INSERT DATA FIRST  ....\n");
	}
	
	public void dataWithoutEntryForContract() {
		System.err.println("\nTHERE IS NO CLIENT DATA IN THE DATA BASE,  INSERT DATA FIRST  ....\n");
	}
	
	public void dataWithoutEntryForLand() {
		System.err.println("\nTHERE IS NO LAND DATA IN THE DATA BASE,  INSERT DATA FIRST  ....\n");
	}
	
}
