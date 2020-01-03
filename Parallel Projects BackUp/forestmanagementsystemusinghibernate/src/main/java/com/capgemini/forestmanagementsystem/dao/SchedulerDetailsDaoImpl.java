package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class SchedulerDetailsDaoImpl implements SchedulerDetailsDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");


	public boolean addScheduler(SchedulerDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nSCHEDULER ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {

			throw new CustomExceptions();
		}
		return true;
	}


	public boolean deleteScheduler(SchedulerDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			SchedulerDetailsDto temp=entityManager.find(SchedulerDetailsDto.class, pdt.getSchedulerid());
			entityManager.remove(temp);
			transaction.commit();
			System.out.println("\nSCHEDULER DELETED SUCCESSFULLY\n");
			return true;
		}
		catch (Exception e) {
			System.err.println("\nTHE SCHEDULER ID THAT YOU HAVE ENTERED IS NOT PRESENT\n");
			// TODO: handle exception
		}

		return false;
	}

	public boolean modifyScheduler(SchedulerDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {		
			transaction.begin();
			SchedulerDetailsDto temp=entityManager.find(SchedulerDetailsDto.class, pdt.getSchedulerid());
			temp.setPassword(pdt.getPassword());	
			entityManager.persist(temp);
			System.out.println("\nPASSWORD MODIFIED SUCCESSFULLY !!\n");
			transaction.commit();
			return true;
			
		}
		catch (Exception e) {
			System.err.println("\nTHE SCHEDULER ID AND PASSWORD DIDN`T MATCHED !!\n");
			// TODO: handle exception
		}

		return false;
	}

	public boolean viewAllScheduler() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from SchedulerDetailsDto"; 
		Query query=entityManager.createQuery(viewall);
		List<SchedulerDetailsDto> result= query.getResultList();
		System.out.println("\n---------SCHEDULER DETAILS------------------");
		for (SchedulerDetailsDto r1 : result) {
			System.out.println(r1);
			System.out.println("--------------------------------------------");
		}

		if(result.isEmpty()) {
			System.err.println("\nTHERE ARE NO SCHEDULER DETAILS  PRESENT IN THE DATABASE!!\n");
			return false;
		}


		return true;

	}

	public SchedulerDetailsDto viewSingleScheduler(SchedulerDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		SchedulerDetailsDto pdd=entityManager.find(SchedulerDetailsDto.class, pdt.getSchedulerid());

		return pdd;
	}

}
