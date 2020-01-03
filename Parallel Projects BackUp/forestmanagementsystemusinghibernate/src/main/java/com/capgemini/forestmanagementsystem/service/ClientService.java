package com.capgemini.forestmanagementsystem.service;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface ClientService {

public boolean addClient(ClientDetailsDto cld) throws CustomExceptions;
	
	public boolean deleteClient(ClientDetailsDto cld);
	
	public boolean modifyClient(ClientDetailsDto cld,String pass);
	
	public boolean viewAllClient();
	
	public ClientDetailsDto viewSingleClient(ClientDetailsDto cld);
	
	
	
}
