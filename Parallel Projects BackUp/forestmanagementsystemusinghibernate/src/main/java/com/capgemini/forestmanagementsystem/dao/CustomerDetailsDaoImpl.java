package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class CustomerDetailsDaoImpl implements CustomerDetailsDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");

	public boolean addCustomer(CustomerDetailsDto pdt) throws CustomExceptions {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nCUSTOMER ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {
			throw new CustomExceptions();
		}

		return true;
	}

	public boolean viewCustomerDetails() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from CustomerDetailsDto";  
		Query query=entityManager.createQuery(viewall);
		List<CustomerDetailsDto> result= query.getResultList();
		System.out.println("\n---------CUSTOMER DETAILS------------------");
		for (CustomerDetailsDto r1 : result) {
			System.out.println(r1);
			System.out.println("--------------------------------------------");
		}

		if(result.isEmpty()) {
			System.err.println("\nTHERE ARE NO CUSTOMER DETAILS  PRESENT IN THE DATABASE!!\n");
			return false;
		}

		return true;
	}

	public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		CustomerDetailsDto pdd=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());

		return pdd;
	}

	public boolean deleteCustomerDetails(CustomerDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());
			entityManager.remove(pddto);
			transaction.commit();
			System.out.println("\nCUSTOMER DELETED SUCCESFULLY !! \n");
			return true;
		}
		catch (Exception e) {
			System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT\n");
			// TODO: handle exception
		}


		return false;

	}

	public boolean modifyCustomerDetails(CustomerDetailsDto pdt, int choice) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		switch (choice) {
		case 1:
			//Street address 1
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());
				pddto.setStreetaddress1(pdt.getStreetaddress1());
				entityManager.persist(pddto);
				System.out.println("\nStreet Address 1 modified successfully !!\n");
				transaction.commit();
				return true;
				}
				catch (Exception e) {
					System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					// TODO: handle exception
				}
			
			break;
		case 2:
			//Street address 2
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());
				pddto.setStreetaddress2(pdt.getStreetaddress2());
				entityManager.persist(pddto);
				System.out.println("\nStreet Address 2 modified successfully !!\n");
				transaction.commit();
				return true;
				}
				catch (Exception e) {
					System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					// TODO: handle exception
				}
			break;
		case 3:
          //town
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());
				pddto.setTown(pdt.getTown());
				entityManager.persist(pddto);
				System.out.println("\nTown modified successfully !!\n");
				transaction.commit();
				return true;
				}
				catch (Exception e) {
					System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					// TODO: handle exception
				}
			break;
		case 4:
          //postal code
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());
				pddto.setPostalcode(pdt.getPostalcode());
				entityManager.persist(pddto);
				System.out.println("\nPostal Code modified successfully !!\n");
				transaction.commit();
				return true;
				}
				catch (Exception e) {
					System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					// TODO: handle exception
				}
			break;
		case 5:
           //email
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());
				pddto.setEmail(pdt.getEmail());
				entityManager.persist(pddto);
				System.out.println("\nE-mail modified successfully !!\n");
				transaction.commit();
				return true;
				}
				catch (Exception e) {
					System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					// TODO: handle exception
				}
			break;
		case 6:
          //telephone number
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerid());
				pddto.setTelephoneno(pdt.getTelephoneno());
				entityManager.persist(pddto);
				System.out.println("\nTelephone number modified successfully !!\n");
				transaction.commit();
				return true;
				}
				catch (Exception e) {
					System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					// TODO: handle exception
				}
			
			break;
		default:
			break;
		}

		return false;
	}






}
