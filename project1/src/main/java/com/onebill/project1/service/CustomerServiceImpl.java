package com.onebill.project1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.project1.dao.CustomerDao;
import com.onebill.project1.dto.Address;
import com.onebill.project1.dto.Customer;
import com.onebill.project1.dto.Email;
import com.onebill.project1.dto.Partner;
import com.onebill.project1.exception.CustomException;
import com.onebill.project1.validations.Validations;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	
	@Override
	public int addCustomer(Customer customer) {
	  
		if(customer.getPartnerId()==0) {
			return 57;
		}
		
		if(customer.getCustomerIdentificationId()==0) {
			return 2;
		}
		
	
		if(! Validations.isStringOnlyAlphabet(customer.getCustomerName())) {
			throw new CustomException("Partner Name can be of alphabets only !!");
		}
		
		if(! Validations.isNumber1(String.valueOf(customer.getCustomerIdentificationId()))) {
			throw new CustomException("Partner identification number can be of integers only only !!");
		}
		
		if(! Validations.isValidDate(customer.getDateOfCommencement())) {
			throw new CustomException("Enter date in dd-mm-yyyy format and should be in past date only !!!!");
		}
		
		if(! Validations.isVaidPhoneNumber(String.valueOf(customer.getPhoneNumber()))) {
			throw new CustomException("Enter phone number of 10 digits only !!!!");
		}
		
		
		
		//Setting the addresses for Customer
				ArrayList<Address> addresses=(ArrayList<Address>) customer.getCustomerAddresses();
				if(!addresses.isEmpty()) {
					for (Address a1 : addresses) {
						a1.setCustomerForAddress(customer);
					}
				customer.setCustomerAddresses(addresses);	
				}else {
					return 4;
				}
				//Setting the email for Customer
				ArrayList<Email> emails=(ArrayList<Email>) customer.getCustomerEmails();
				
				if(!emails.isEmpty()) {
					for (Email e1 : emails) {
						e1.setCustomerEmail(customer);
					}
					customer.setCustomerEmails(emails);	
				}else {
					return 5;
				}
				
		return customerDao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		
		return customerDao.deleteCustomer(customer);
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		
		return customerDao.viewCustomer(customer);
	}

	@Override
	public List<Customer> viewAllCustomers() {
		
		return customerDao.viewAllCustomers();
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}

	@Override
	public int reviseCustomer(Customer customer) {
		if(customer.getPartnerId()==0) {
			return 57;
		}
		
		
		//Setting the addresses for Customer
		ArrayList<Address> addresses=(ArrayList<Address>) customer.getCustomerAddresses();
		if(!addresses.isEmpty()) {
			for (Address a1 : addresses) {
				a1.setCustomerForAddress(customer);
			}
		customer.setCustomerAddresses(addresses);	
		}else {
			return 4;
		}
		//Setting the email for Customer
		ArrayList<Email> emails=(ArrayList<Email>) customer.getCustomerEmails();
		
		if(!emails.isEmpty()) {
			for (Email e1 : emails) {
				e1.setCustomerEmail(customer);
			}
			customer.setCustomerEmails(emails);	
		}else {
			return 5;
		}
		
		
		return customerDao.reviseCustomer(customer);
	}

	
	
	
}
