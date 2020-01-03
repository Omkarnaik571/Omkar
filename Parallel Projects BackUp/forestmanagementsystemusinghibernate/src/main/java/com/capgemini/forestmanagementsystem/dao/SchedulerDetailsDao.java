package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface SchedulerDetailsDao {

   public boolean addScheduler(SchedulerDetailsDto pdt) throws CustomExceptions;
	
	public boolean deleteScheduler(SchedulerDetailsDto pdt);
	
	public boolean modifyScheduler(SchedulerDetailsDto pdt);
	
	public boolean viewAllScheduler();
	
	public SchedulerDetailsDto viewSingleScheduler(SchedulerDetailsDto pdt);
}
