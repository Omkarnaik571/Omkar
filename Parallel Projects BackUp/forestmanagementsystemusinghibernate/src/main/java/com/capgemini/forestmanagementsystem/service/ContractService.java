package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public interface ContractService {

	 //1. add a Contractor
	public boolean addContractor(ContractorDetailsDto cdd ) throws ContractCustomException;
//2. View all the Contractor detail
	public List<ContractorDetailsDto> viewContractorDetails() throws CustomExceptions;
//3. View single Contractor detail
	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto cdd ) throws CustomExceptions;
//4. delete a Contractor detail	
	public boolean deleteContractorDetails(ContractorDetailsDto cdd ) throws CustomExceptions;
//5. Modify a Contractor detail	
	public boolean modifyContractorDetails(ContractorDetailsDto cdd,int cno ) throws CustomExceptions;
	
	
	
}
