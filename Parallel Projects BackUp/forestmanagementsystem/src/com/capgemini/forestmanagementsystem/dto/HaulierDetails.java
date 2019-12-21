package com.capgemini.forestmanagementsystem.dto;

public class HaulierDetails {
	int haulierid;
	String hauliername;
	String haulieraddess;
	int hauliercontactno;
	public int getHaulierid() {
		return haulierid;
	}
	public void setHaulierid(int haulierid) {
		this.haulierid = haulierid;
	}
	public String getHauliername() {
		return hauliername;
	}
	public void setHauliername(String hauliername) {
		this.hauliername = hauliername;
	}
	public String getHaulieraddess() {
		return haulieraddess;
	}
	public void setHaulieraddess(String haulieraddess) {
		this.haulieraddess = haulieraddess;
	}
	public int getHauliercontactno() {
		return hauliercontactno;
	}
	public void setHauliercontactno(int hauliercontactno) {
		this.hauliercontactno = hauliercontactno;
	}
	@Override
	public String toString() {
		return "HAULIER ID : " + haulierid + "\nHAULIER NAME : " + hauliername + "\nHAULIER ADDDRESS : "
				+ haulieraddess + "\nHAULIER CONTACT NUMBER : " + hauliercontactno;
	}


	
	
	
	

}
