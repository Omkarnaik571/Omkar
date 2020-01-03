package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ContractDetailsDaoImpl implements ContractorDetailsDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");

	public boolean addContractor(ContractorDetailsDto pdt) throws ContractCustomException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nCONTRACT ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {

			throw new ContractCustomException();
		}

		return true;
	}//end of add contractor



	public boolean viewContractorDetails() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from ContractorDetailsDto";  
		Query query=entityManager.createQuery(viewall);
		List<ContractorDetailsDto> result= query.getResultList();
		System.out.println("\n---------CONTRACT DETAILS------------------");
		for (ContractorDetailsDto r1 : result) {
			System.out.println(r1);
			System.out.println("--------------------------------------------");
		}

		if(result.isEmpty()) {
			System.err.println("\nTHERE ARE NO CONTRACT DETAILS  PRESENT IN THE DATABASE!!\n");
			return false;
		}

		return true;
	}//end of view all contractor



	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		ContractorDetailsDto pdd=entityManager.find(ContractorDetailsDto.class,pdt.getContractno() );

		return pdd;

	}//end of view single contractor




	public boolean deleteContractorDetails(ContractorDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractno());
			entityManager.remove(pddto);
			transaction.commit();
			System.out.println("\nCONTRACT DELETED SUCCESFULLY !! \n");
			return true;
		}
		catch (Exception e) {
			System.err.println("\nTHE CONTRCAT NO THAT YOU HAVE ENTERED IS NOT PRESENT\n");
			// TODO: handle exception
		}


		return false;
	}//end of delete contractor


	public boolean modifyContractorDetails(ContractorDetailsDto pdt, int cno) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		switch (cno) {
		case 1:
			//d date
			try {
				transaction.begin();
				ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractno());
				pddto.setDeliverydate(pdt.getDeliverydate());
				entityManager.persist(pddto);
				System.out.println("\nDelivery date modified successfully !!\n");
				transaction.commit();
				return true;
			}
			catch (Exception e) {
				System.err.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
				// TODO: handle exception
			}

			break;
		case 2:
			//d day
			try {
				transaction.begin();
				ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractno());
				pddto.setDeliveryday(pdt.getDeliveryday());
				entityManager.persist(pddto);
				System.out.println("\nDelivery day modified successfully !!\n");
				transaction.commit();
				return true;
			}
			catch (Exception e) {
				System.err.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
				// TODO: handle exception
			}
			break;
		case 3:
			//quantity
			try {
				transaction.begin();
				ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractno());
				pddto.setQuantity(pdt.getQuantity());
				entityManager.persist(pddto);
				System.out.println("\nQuantity modified successfully !!\n");
				transaction.commit();
				return true;
			}
			catch (Exception e) {
				System.err.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
				// TODO: handle exception
			}

			break;
		case 4:
			//quantity
			try {
				transaction.begin();
				ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractno());
				pddto.setContractstatus(pdt.getContractstatus());
				entityManager.persist(pddto);
				System.out.println("\nContract Status modified successfully !!\n");
				transaction.commit();
				return true;
			}
			catch (Exception e) {
				System.err.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
				// TODO: handle exception
			}

			break;
		default:
			break;
		}

		return false;
	}//end of modify contractor













}
