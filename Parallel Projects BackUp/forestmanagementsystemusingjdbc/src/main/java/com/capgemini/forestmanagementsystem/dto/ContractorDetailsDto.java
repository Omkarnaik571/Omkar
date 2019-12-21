package com.capgemini.forestmanagementsystem.dto;

import lombok.Data;

@Data
public class ContractorDetailsDto {
	private int contractno;
	private int customerid;
	private int productid;
	private int haulierid;
	private String deliverydate;
	private String deliveryday;
	private String quantity;
	

	
}
