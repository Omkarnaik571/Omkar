package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@javax.persistence.Table(name="contrcatordetails")
public class ContractorDetailsDto {
	@Id
	@Column
	private int contractno;
	@Column
	private int customerid;
	@Column
	private int productid;
	@Column
	private int haulierid;
	@Column
	private String deliverydate;
	@Column
	private String deliveryday;
	@Column
	private String quantity;
	@Column
	private String contractstatus="pending";
	public int getContractno() {
		return contractno;
	}
	public void setContractno(int contractno) {
		this.contractno = contractno;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getHaulierid() {
		return haulierid;
	}
	public void setHaulierid(int haulierid) {
		this.haulierid = haulierid;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	public String getDeliveryday() {
		return deliveryday;
	}
	public void setDeliveryday(String deliveryday) {
		this.deliveryday = deliveryday;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getContractstatus() {
		return contractstatus;
	}
	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}
	@Override
	public String toString() {
		return "Contract no : " + contractno + "\nCustomer id : " + customerid + "\nProduct id : "
				+ productid + "\nHaulier id : " + haulierid + "\nDelivery date : " + deliverydate + "\nDelivery day : "
				+ deliveryday + "\nQuantity : " + quantity + "\nContract status : " + contractstatus;
	}
	
	
	
	
	
	
	
	
	
	
	
}
