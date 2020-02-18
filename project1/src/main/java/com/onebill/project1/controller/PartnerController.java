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
import com.onebill.project1.service.PartnerService;

@RestController
@CrossOrigin
@RequestMapping("/partner-operations")
public class PartnerController {

	@Autowired
	PartnerService partnerService;
	
	
	@PostMapping(path = "/addPartner", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PartnerResponse insertPartner(@RequestBody Partner partner) {
		PartnerResponse response=new PartnerResponse();
		
		int isadded=partnerService.addPartner(partner);
		if(isadded ==1) {
			response.setStatusCode(200);
			response.setMessage("Partner Details Added successfully !!");
		}else if(isadded ==2) {
			response.setStatusCode(300);
			response.setMessage("Partner identification number is mandatory !!");
		}
		else {
			response.setStatusCode(300);
			response.setMessage("Partner Details could`nt be added !!");
		}
		
		return response;
	}
	
   
	@PostMapping(path = "/viewPartner", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PartnerResponse displayPartner(@RequestBody Partner partner) {
		PartnerResponse response=new PartnerResponse();
		
		Partner partnerFound=partnerService.viewPartner(partner);
		if(partnerFound!=null) {
			response.setStatusCode(200);
			response.setMessage("Partner Details found !!");
			response.setPartner(partnerFound);
		}else {
			response.setStatusCode(300);
			response.setMessage("Partner Details not found !!");
			response.setPartner(null);
		}
		
		return response;
	}

	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Partner>  viewAllPartners() {
		
		List<Partner> partners=partnerService.viewAllPartner();
		return partners;
	}
	
	
	
	@PutMapping(path = "/{partnerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PartnerResponse removeCustomer(@PathVariable("partnerId") int partnerId) {
		PartnerResponse response = new PartnerResponse();
		Partner partner=new Partner();
		partner.setPartnerId(partnerId);

		if (partnerService.deletePartner(partner)) {
			response.setStatusCode(200);
			response.setMessage("Partner deleted !!");
		}else {
			response.setStatusCode(300);
			response.setMessage("Partner deletion failed, id does`nt exists !!");
		}

		return response;
	}
	
	
	@PostMapping(path = "reactivatePartner/{partnerId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PartnerResponse updatePartner(@PathVariable("partnerId") int partnerId) {
		PartnerResponse response = new PartnerResponse();
		Partner partner=new Partner();
		partner.setPartnerId(partnerId);

		if (partnerService.updatePartner(partner)) {
			response.setStatusCode(200);
			response.setMessage("Partner reactivated !!");
		}else {
			response.setStatusCode(300);
			response.setMessage("Partner reactivation failed, id does`nt exists !!");
		}

		return response;
	}


	
	
	
	
	
}
