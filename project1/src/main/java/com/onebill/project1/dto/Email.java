package com.onebill.project1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Email {
	
	@Id
	@Column
	@GeneratedValue
	private int emailId;
	@Column
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "partnerId")
	@JsonIgnore
	private Partner partnerEmail;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customerEmail;

	public int getEmailId() {
		return emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Partner getPartnerEmail() {
		return partnerEmail;
	}

	public void setPartnerEmail(Partner partnerEmail) {
		this.partnerEmail = partnerEmail;
	}

	public Customer getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(Customer customerEmail) {
		this.customerEmail = customerEmail;
	}
	

	
	
	
}
