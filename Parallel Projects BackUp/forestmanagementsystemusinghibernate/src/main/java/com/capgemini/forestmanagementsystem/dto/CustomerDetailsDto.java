package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerdetails")
public class CustomerDetailsDto {
	@Id
	@Column
	private int	customerid; 
	@Column
	private String	customername; 
	@Column
	private String	streetaddress1;  
	@Column
	private String	streetaddress2; 
	@Column
	private String	town;  
	@Column
	private int	postalcode; 
	@Column
	private String	email; 
	@Column
	private long	telephoneno;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getStreetaddress1() {
		return streetaddress1;
	}
	public void setStreetaddress1(String streetaddress1) {
		this.streetaddress1 = streetaddress1;
	}
	public String getStreetaddress2() {
		return streetaddress2;
	}
	public void setStreetaddress2(String streetaddress2) {
		this.streetaddress2 = streetaddress2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelephoneno() {
		return telephoneno;
	}
	public void setTelephoneno(long telephoneno) {
		this.telephoneno = telephoneno;
	}
	@Override
	public String toString() {
		return "Customer id : " + customerid + "\nCustomer name : " + customername + "\nStreet Address1 : "
				+ streetaddress1 + "\nStreet Address2 : " + streetaddress2 + "\nTown : " + town + "\nPostalcode : "
				+ postalcode + "\nE-mail : " + email + "\nTelephoneno : " + telephoneno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerid;
		result = prime * result + ((customername == null) ? 0 : customername.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + postalcode;
		result = prime * result + ((streetaddress1 == null) ? 0 : streetaddress1.hashCode());
		result = prime * result + ((streetaddress2 == null) ? 0 : streetaddress2.hashCode());
		result = prime * result + (int) (telephoneno ^ (telephoneno >>> 32));
		result = prime * result + ((town == null) ? 0 : town.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDetailsDto other = (CustomerDetailsDto) obj;
		if (customerid != other.customerid)
			return false;
		if (customername == null) {
			if (other.customername != null)
				return false;
		} else if (!customername.equals(other.customername))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (postalcode != other.postalcode)
			return false;
		if (streetaddress1 == null) {
			if (other.streetaddress1 != null)
				return false;
		} else if (!streetaddress1.equals(other.streetaddress1))
			return false;
		if (streetaddress2 == null) {
			if (other.streetaddress2 != null)
				return false;
		} else if (!streetaddress2.equals(other.streetaddress2))
			return false;
		if (telephoneno != other.telephoneno)
			return false;
		if (town == null) {
			if (other.town != null)
				return false;
		} else if (!town.equals(other.town))
			return false;
		return true;
	}
	
	
	
	

}
