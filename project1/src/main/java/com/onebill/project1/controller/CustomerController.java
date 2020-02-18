package com.onebill.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.project1.dto.Customer;
import com.onebill.project1.dto.CustomerResponse;
import com.onebill.project1.dto.Partner;
import com.onebill.project1.dto.PartnerResponse;
import com.onebill.project1.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer-operations")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(path = "/addCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse insertCustomer(@RequestBody Customer customer) {
		CustomerResponse response = new CustomerResponse();

		int isadded = customerService.addCustomer(customer);
		if (isadded == 1) {
			response.setStatusCode(200);
			response.setMessage("Customer Details Added successfully !!");
		} else if (isadded == 4) {
			response.setStatusCode(400);
			response.setMessage("Customer address details are empty !!");
		} else if (isadded == 5) {
			response.setStatusCode(500);
			response.setMessage("Customer email details are empty !!");
		} else if (isadded == 57) {
			response.setStatusCode(570);
			response.setMessage("Partner id is mandatory while adding a customer !!");
		}else if(isadded ==2) {
			response.setStatusCode(300);
			response.setMessage("Partner identification number is mandatory !!");
		} else {
			response.setStatusCode(300);
			response.setMessage("Customer Details could`nt be added !!");
		}

		return response;
	}
	
	@PostMapping(path = "/updateCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse reviseCustomer(@RequestBody Customer customer) {
		CustomerResponse response = new CustomerResponse();

		int isadded = customerService.reviseCustomer(customer);
		if (isadded == 1) {
			response.setStatusCode(200);
			response.setMessage("Customer Details Added successfully !!");
		} else if (isadded == 4) {
			response.setStatusCode(400);
			response.setMessage("Customer address details are empty !!");
		} else if (isadded == 5) {
			response.setStatusCode(500);
			response.setMessage("Customer email details are empty !!");
		} else if (isadded == 57) {
			response.setStatusCode(570);
			response.setMessage("Partner id is mandatory while adding a customer !!");
		} else {
			response.setStatusCode(300);
			response.setMessage("Customer Details could`nt be added !!");
		}

		return response;
	}

	
	

	@PostMapping(path = "/viewCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse displayCustomer(@RequestBody Customer customer) {
		CustomerResponse response = new CustomerResponse();

		if (customer.getCustomerId() == 0) {
			response.setStatusCode(300);
			response.setMessage("You have passed empty values !!");

			return response;
		}
		
		Customer customerFound = customerService.viewCustomer(customer);
		if (customerFound != null) {
			response.setStatusCode(200);
			response.setMessage("Customer Details found !!");
			response.setCustomer(customerFound);
		} else {
			response.setStatusCode(300);
			response.setMessage("Customer id that you have entered does`nt exists !!");

		}

		return response;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> viewAllPartners() {

		List<Customer> customers = customerService.viewAllCustomers();
		return customers;
	}

	@PutMapping(path = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse removeCustomer(@PathVariable("customerId") int customerId) {
		CustomerResponse response = new CustomerResponse();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);

		if (customerService.deleteCustomer(customer)) {
			response.setStatusCode(200);
			response.setMessage("Customer deleted !!");
		}else {
			response.setStatusCode(300);
			response.setMessage("Customer deletion failed, id does`nt exists !!");
		}

		return response;
	}
	
	
	@PostMapping(path = "reactivateCustomer/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse updateCustomer(@PathVariable("customerId") int customerId) {
		CustomerResponse response = new CustomerResponse();
		Customer customer = new Customer();
		customer.setCustomerId(customerId);

		if (customerService.updateCustomer(customer)) {
			response.setStatusCode(200);
			response.setMessage("Customer updated !!");
		}else {
			response.setStatusCode(300);
			response.setMessage("Customer updation failed, id does`nt exists !!");
		}

		return response;
	}


}
