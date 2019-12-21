package com.capgemini.forestmanagementsystem.dto;

import lombok.Data;

@Data
public class CustomerDetailsDto {
	private int	customerid; 
	private String	customername; 
	private String	streetaddress1;  
	private String	streetaddress2; 
	private String	town;  
	private int	postalcode; 
	private String	email; 
	private long	telephoneno;
	private String	password;
	
	

}
