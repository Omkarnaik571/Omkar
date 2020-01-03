package com.capgemini.forestmanagementsystem.factory;

import com.capgemini.forestmanagementsystem.dao.ClientDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dao.SchedulerDetailsDao;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.service.ClientService;
import com.capgemini.forestmanagementsystem.service.ClientServiceImpl;
import com.capgemini.forestmanagementsystem.service.ContractService;
import com.capgemini.forestmanagementsystem.service.ContractorServiceImpl;
import com.capgemini.forestmanagementsystem.service.CustomerService;
import com.capgemini.forestmanagementsystem.service.CustomerServiceImpl;
import com.capgemini.forestmanagementsystem.service.ProductService;
import com.capgemini.forestmanagementsystem.service.ProductServiceImpl;
import com.capgemini.forestmanagementsystem.service.SchedulerService;
import com.capgemini.forestmanagementsystem.service.SchedulerServiceImpl;

public class FactoryClass {


	//1. client details dto object
	public static ClientDetailsDto getClientDetailsDto() {
		return new ClientDetailsDto();
	}

	//. Scheduler details dto
	public static SchedulerDetailsDto getSchedulerDetailsDto() {
		return new SchedulerDetailsDto();
	}

	//2. Contractor details dto object
	public static ContractorDetailsDto  getContractorDetailsDto() {
		return new ContractorDetailsDto();
	}

	//3. customer details dto object
	public static CustomerDetailsDto  getCustomerDetailsDto() {
		return new CustomerDetailsDto();
	}


	//4. Land details dto object
	public static LandDetailsDto  getLandDetailsDto() {
		return new LandDetailsDto();
	}


	//5. Product details dto object
	public static ProductDetailsDto  getProductDetailsDto() {
		return new ProductDetailsDto();
	}

	//6. product details service impl object
	public static ProductService  getProductDetailsServiceImpl() {
		return new ProductServiceImpl();
	}

	//7. contract details service impl object
	public static ContractService  getContractDetailsServiceImpl() {
		return new ContractorServiceImpl();
	}

	//8. customer details service impl object
	public static CustomerService  getCustomerDetailsServiceImpl() {
		return new CustomerServiceImpl();
	}

	//9. Client details service impl object
	public static ClientService  getClientDetailsServiceImpl() {
		return new ClientServiceImpl();
	}

	//10. Scheduler details service impl object
	public static SchedulerService  getSchedulerDetailsServiceImpl() {
		return new SchedulerServiceImpl();
	}



}
