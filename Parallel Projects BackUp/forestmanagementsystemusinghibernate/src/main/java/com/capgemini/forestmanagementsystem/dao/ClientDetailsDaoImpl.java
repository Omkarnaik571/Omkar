package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ClientDetailsDaoImpl implements ClientDetailsDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");
	
	
	public boolean addClient(ClientDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nCLIENT ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {
             throw new CustomExceptions();
		}
		return true;
	}

	public boolean deleteClient(ClientDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			
ClientDetailsDto cdt=entityManager.find(ClientDetailsDto.class, pdt.getClientid());	
     if(pdt.getPassword().equals(cdt.getPassword())) {
    	 transaction.begin();
 		entityManager.remove(cdt);
 		System.out.println("\nCLIENT DELETED SUCCESSFULLY !!\n");
 			transaction.commit();
 			return true;
     }			
			
			
		}
		catch (Exception e) {
			transaction.rollback();
			System.err.println("\nTHE CLIENT ID THAT YOU HAVE ENTERED IS NOT PRESENT\n");
			// TODO: handle exception
		}


		return false;
	}

	public boolean modifyClient(ClientDetailsDto pdt, String pass) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		
          ClientDetailsDto cdt=entityManager.find(ClientDetailsDto.class, pdt.getClientid());	   
          if(cdt.getPassword().equals(pass)) {
        	  cdt.setPassword(pdt.getPassword());
        	  transaction.begin();
              entityManager.persist(cdt);
              System.out.println("\nCLIENT MODIFIED SUCCESSFULLY !!\n");
              transaction.commit();  
          }
          
		
			System.out.println("\nCLIENT PASSWORD MODIFIED SUCCESSFULLY\n");
			return true;

		}
		catch (Exception e) {
			System.err.println("\nTHE CLIENT ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
			// TODO: handle exception
		}
		
		return false;
	}

	public boolean viewAllClient() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from ClientDetailsDto"; 
		Query query=entityManager.createQuery(viewall);
		List<ClientDetailsDto> result= query.getResultList();
		System.out.println("\n---------CLIENT DETAILS------------------");
		for (ClientDetailsDto r1 : result) {
			System.out.println(r1);
			System.out.println("--------------------------------------------");
		}

		if(result.isEmpty()) {
			System.err.println("\nTHERE ARE NO CLIENTS DETAILS  PRESENT IN THE DATABASE!!\n");
			return false;
		}


		return true;
		
	}

	public ClientDetailsDto viewSingleClient(ClientDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		ClientDetailsDto pdd=entityManager.find(ClientDetailsDto.class, pdt.getClientid());
			
			return pdd;
	}

}
