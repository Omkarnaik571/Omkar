package com.capgemini.forestmanagementsystem.service;

import com.capgemini.forestmanagementsystem.dao.SchedulerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.SchedulerDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class SchedulerServiceImpl implements SchedulerService {
       SchedulerDetailsDao dao=new SchedulerDetailsDaoImpl();
	
	
	public boolean addScheduler(SchedulerDetailsDto pdt) throws CustomExceptions {
		
		
		return dao.addScheduler(pdt);
	}

	public boolean deleteScheduler(SchedulerDetailsDto pdt) {
		
		
		return dao.deleteScheduler(pdt);
	}

	
	
	public boolean modifyScheduler(SchedulerDetailsDto pdt) {
		
		
		return dao.modifyScheduler(pdt);
	}

	
	
	public boolean viewAllScheduler() {
		
		
		return dao.viewAllScheduler();
	}

	
	
	public SchedulerDetailsDto viewSingleScheduler(SchedulerDetailsDto pdt) {
		
		
		
		return dao.viewSingleScheduler(pdt);
	}

	
	
	
	
}
