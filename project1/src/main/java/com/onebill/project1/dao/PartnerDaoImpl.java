package com.onebill.project1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.onebill.project1.dto.Partner;
import com.onebill.project1.exception.CustomException;

@Repository
public class PartnerDaoImpl implements PartnerDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public int addPartner(Partner partner) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(partner);
			transaction.commit();
			
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("The unique identification number already exists !!");
		}
		
	}

	@Override
	public Partner viewPartner(Partner partner) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Partner partnerFound=entityManager.find(partner.getClass(), partner.getPartnerId());
			
			return partnerFound;
		}catch (Exception e) {
			throw new CustomException("Error while retriving values from partner dao");
		}
		
	}

	@Override
	public List<Partner> viewAllPartner() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from Partner where permission=:per";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("per", "active");
		@SuppressWarnings("unchecked")
		List<Partner> partners=query.getResultList();
		
		return partners;
		}catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public boolean deletePartner(Partner partner) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			String jpql = "update Partner set permission=:per where partnerId=:pId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("per", "deleted");
			query.setParameter("pId", partner.getPartnerId());
			transaction.begin();
			int isModified = query.executeUpdate();
			transaction.commit();
			if (isModified > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new CustomException("Error while deleting in partner daoimpl");
		}

	}

	@Override
	public boolean updatePartner(Partner partner) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			String jpql = "update Partner set permission=:per where partnerId=:cId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("per", "active");
			query.setParameter("cId", partner.getPartnerId());
			transaction.begin();
			int isModified = query.executeUpdate();
			transaction.commit();
			if (isModified > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			throw new CustomException("Partner re activation failed !!");
		}
	}
	
	
	
	

}
