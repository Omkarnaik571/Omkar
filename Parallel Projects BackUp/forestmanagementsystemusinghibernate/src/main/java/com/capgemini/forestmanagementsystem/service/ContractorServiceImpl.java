package com.capgemini.forestmanagementsystem.service;

import com.capgemini.forestmanagementsystem.dao.ContractDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;

public class ContractorServiceImpl implements ContractService{

	ContractorDetailsDao dao=new ContractDetailsDaoImpl();
	
	public boolean addContractor(ContractorDetailsDto cdd) throws ContractCustomException {
		
		return dao.addContractor(cdd);
	}

	public boolean viewContractorDetails() {
		
		return dao.viewContractorDetails();
	}

	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto cdd) {
		
		return dao.viewSingleContractorDetails(cdd);
	}

	public boolean deleteContractorDetails(ContractorDetailsDto cdd) {
		
		return dao.deleteContractorDetails(cdd);
	}

	public boolean modifyContractorDetails(ContractorDetailsDto cdd, int cno) {

		return dao.modifyContractorDetails(cdd, cno);
	}

}
