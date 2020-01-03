package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ProductDetailsDaoImpl implements ProductDao{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");


	public boolean addProduct(ProductDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nPRODUCT ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {

			throw new CustomExceptions();
		}
		return true;

	}//end of add product


	public boolean deleteProduct(ProductDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			ProductDetailsDto pddto=entityManager.find(ProductDetailsDto.class, pdt.getProductid());
			entityManager.remove(pddto);
			transaction.commit();
			System.out.println("\nPRODUCT DELETED SUCCESFULLY !! \n");
			return true;
		}
		catch (Exception e) {
			System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT\n");
			// TODO: handle exception
		}


		return false;
	}//end of delete product

	public boolean modifyProduct(ProductDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		transaction.begin();
		ProductDetailsDto pddto=entityManager.find(ProductDetailsDto.class, pdt.getProductid());
		pddto.setProductname(pdt.getProductname());
		entityManager.persist(pddto);
		System.out.println("\nProduct name modified successfully !!\n");
		transaction.commit();
		return true;
		}
		catch (Exception e) {
			System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
			// TODO: handle exception
		}
		

		return false;
	}//end of modify product

	public boolean viewAllProduct() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from ProductDetailsDto"; 
		Query query=entityManager.createQuery(viewall);
		List<ProductDetailsDto> result= query.getResultList();
		System.out.println("\n---------PRODUCT DETAILS------------------");
		for (ProductDetailsDto r1 : result) {
			System.out.println(r1);
			System.out.println("--------------------------------------------");
		}

		if(result.isEmpty()) {
			System.out.println("\nTHERE ARE NO PRODUCT DETAILS  PRESENT IN THE DATABASE!!\n");
			return false;
		}


		return true;
	}//end of view all

	public ProductDetailsDto viewParticularProduct(ProductDetailsDto pdt) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		ProductDetailsDto pdd=entityManager.find(ProductDetailsDto.class, pdt.getProductid());
			
			return pdd;
		
	}//end of view single




}
