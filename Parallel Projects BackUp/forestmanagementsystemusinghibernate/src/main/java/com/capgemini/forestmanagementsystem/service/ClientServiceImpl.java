package com.capgemini.forestmanagementsystem.service;

import com.capgemini.forestmanagementsystem.dao.ClientDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ClientDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ClientServiceImpl  implements ClientService{

	       ClientDetailsDao dao =new ClientDetailsDaoImpl();
	
	public boolean addClient(ClientDetailsDto cld) throws CustomExceptions {
		
		return dao.addClient(cld);
	}

	public boolean deleteClient(ClientDetailsDto cld) {
		
		return dao.deleteClient(cld);
	}

	public boolean modifyClient(ClientDetailsDto cld, String pass) {
		
		return dao.modifyClient(cld, pass);
	}

	public boolean viewAllClient() {
		
		return dao.viewAllClient();
	}

	public ClientDetailsDto viewSingleClient(ClientDetailsDto cld) {

		return dao.viewSingleClient(cld);
	}

}
