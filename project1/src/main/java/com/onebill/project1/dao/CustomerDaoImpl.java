package com.onebill.project1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.onebill.project1.dto.Address;
import com.onebill.project1.dto.Customer;
import com.onebill.project1.dto.Partner;
import com.onebill.project1.exception.CustomException;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public int addCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {

			Partner partner = entityManager.find(Partner.class, customer.getPartnerId());

			customer.setPartner(partner);

			transaction.begin();
			entityManager.persist(customer);
			transaction.commit();

			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Enter a different email id`s");
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			String jpql = "update Customer set permission=:per where customerId=:cId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("per", "deleted");
			query.setParameter("cId", customer.getCustomerId());
			transaction.begin();
			int isModified = query.executeUpdate();
			transaction.commit();
			if (isModified > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new CustomException("Error while deleting in customer daoimpl");
		}

	}

	@Override
	public Customer viewCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Customer customerFound = entityManager.find(Customer.class, customer.getCustomerId());
			if (customerFound.getPermission().equals("deleted")) {
				return null;
			}

			return customerFound;
		} catch (Exception e) {
			throw new CustomException("Error while retriving values from customer dao");
		}

	}

	@Override
	public List<Customer> viewAllCustomers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from Customer where permission=:per";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("per", "active");
			@SuppressWarnings("unchecked")
			List<Customer> customers = query.getResultList();

			return customers;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			String jpql = "update Customer set permission=:per where customerId=:cId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("per", "active");
			query.setParameter("cId", customer.getCustomerId());
			transaction.begin();
			int isModified = query.executeUpdate();
			transaction.commit();
			if (isModified > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new CustomException("Error while updating in customer daoimpl");
		}
	}

	@Override
	public int reviseCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			
			Partner partner = entityManager.find(Partner.class, customer.getPartnerId());
			customer.setPartner(partner);
			
			Customer customerFound = entityManager.find(Customer.class, customer.getCustomerId());
            System.out.println(customerFound==null); 
			
			customerFound.setPartnerId(customer.getPartnerId());
			customerFound.setPermission(customer.getPermission());
			customerFound.setPhoneNumber(customer.getPhoneNumber());
			customerFound.setDateOfCommencement(customer.getDateOfCommencement());
			customerFound.setCustomerName(customer.getCustomerName());
			customerFound.setCustomerEmails(customer.getCustomerEmails());
			customerFound.setCustomerAddresses(customer.getCustomerAddresses());
			customerFound.setPartner(customer.getPartner());
			
//			String jpql="delete from Address where customerId=:cId";
//			Query query=entityManager.createQuery(jpql);
//			query.setParameter("cId", customer.getCustomerId());
//			   query.executeUpdate();
//			   transaction.commit();
			
					transaction.commit();
            return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Error while revising customer details");
		}

	}

}
