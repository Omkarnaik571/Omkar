package com.onebill.project1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.project1.dao.PartnerDao;
import com.onebill.project1.dto.Address;
import com.onebill.project1.dto.Customer;
import com.onebill.project1.dto.Email;
import com.onebill.project1.dto.Partner;
import com.onebill.project1.exception.CustomException;
import com.onebill.project1.validations.Validations;

@Service
public class PartnerServiceImpl implements PartnerService{

	@Autowired
	PartnerDao partnerDao;
	
	
	@Override
	public int addPartner(Partner partner) {
		
		//To check whether identification id is present or not
		if(partner.getPartnerIdentificationId()==0) {
			return 2;
		}
	
		if(! Validations.isStringOnlyAlphabet(partner.getPartnerName())) {
			throw new CustomException("Partner Name can be of alphabets only !!");
		}
		
		if(! Validations.isNumber1(String.valueOf(partner.getPartnerIdentificationId()))) {
			throw new CustomException("Partner identification number can be of integers only only !!");
		}
		
		if(! Validations.isValidDate(partner.getDateOfCommencement())) {
			throw new CustomException("Enter date in dd-mm-yyyy format and should be in past date only !!!!");
		}
		
		if(! Validations.isVaidPhoneNumber(String.valueOf(partner.getPhoneNumber()))) {
			throw new CustomException("Enter phone number of 10 digits only !!!!");
		}
		
	
		
		//If customer data are added with partner data
		ArrayList<Customer> customers=(ArrayList<Customer>) partner.getCustomers();
		  
		if(!customers.isEmpty()) {
			
			for (Customer c1 : customers) {
				//Setting up the addresses for each customers
				ArrayList<Address> customerAddress=(ArrayList<Address>) c1.getCustomerAddresses();
			     for (Address cAddrs : customerAddress) {
					cAddrs.setCustomerForAddress(c1);
					c1.setCustomerAddresses(customerAddress);
				}
			   //Setting up the email for each customers
			   ArrayList<Email> customerEmails=(ArrayList<Email>) c1.getCustomerEmails();
			   for (Email cEmails : customerEmails) {
				cEmails.setCustomerEmail(c1);
				c1.setCustomerEmails(customerEmails);
			}
			     
				c1.setPartner(partner);
			}
			partner.setCustomers(customers);	
			
		}
				
		
		//Setting the addresses for partner
		ArrayList<Address> addresses=(ArrayList<Address>) partner.getPartnerAddresses();
		if(!addresses.isEmpty()) {
			for (Address a1 : addresses) {
				a1.setPartnerForAddress(partner);
			}
			partner.setPartnerAddresses(addresses);	
		}
		
		//Setting the email for partner
		ArrayList<Email> emails=(ArrayList<Email>) partner.getPartnerEmails();
		
		if(!emails.isEmpty()) {
			for (Email e1 : emails) {
				e1.setPartnerEmail(partner);
			}
			partner.setPartnerEmails(emails);	
		}
		
		
		
		return partnerDao.addPartner(partner);
	}

	@Override
	public Partner viewPartner(Partner partner) {
		
		return partnerDao.viewPartner(partner);
	}

	@Override
	public List<Partner> viewAllPartner() {
		
		return partnerDao.viewAllPartner();
	}

	@Override
	public boolean deletePartner(Partner partner) {
		
		return partnerDao.deletePartner(partner);
	}

	@Override
	public boolean updatePartner(Partner partner) {
		
		return partnerDao.updatePartner(partner);
	}

	
	
	
	
	
}
