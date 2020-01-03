package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productdetails")
public class ProductDetailsDto {
	@Id
	@Column
	private int productid;
	@Column
	private String productname;
	
	
	
	@Override
	public String toString() {
		return "Productid : " + productid + "\nProductname : " + productname;
	}
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productid;
		result = prime * result + ((productname == null) ? 0 : productname.hashCode());
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
		ProductDetailsDto other = (ProductDetailsDto) obj;
		if (productid != other.productid)
			return false;
		if (productname == null) {
			if (other.productname != null)
				return false;
		} else if (!productname.equals(other.productname))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
