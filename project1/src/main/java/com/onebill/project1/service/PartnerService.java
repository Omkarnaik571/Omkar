package com.onebill.project1.service;

import java.util.List;

import com.onebill.project1.dto.Partner;

public interface PartnerService {

	public int addPartner(Partner partner);

	public Partner viewPartner(Partner partner);
	
	public List<Partner> viewAllPartner();
	
	public boolean deletePartner(Partner partner);

	public boolean updatePartner(Partner partner);
	

}
