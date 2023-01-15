package com.ty.many_to_one.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_Bank.dto.Bank;
import many_to_one_Bank.dto.Branch;

public class BankCRUD {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory( "venu");
		return entityManagerFactory.createEntityManager();
	}
	public void saveBank(Bank bank)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist( bank);
		entityTransaction.commit();
	}
	public void updateBank(int id,Bank bank)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		if(bank !=null)
		{
			bank.setId(id);
			entityTransaction.begin();
			entityManager.merge( bank);
			entityTransaction.commit();
		}
		else {
			System.out.println("The Bank does not Exist");
		}
	}
	public void deleteBank(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank=entityManager.find( Bank.class, id);
		if(bank !=null)
		{
			bank.setId(id);
			entityTransaction.begin();
			entityManager.remove( bank);
			entityTransaction.commit();
		}
		else {
			System.out.println("The Bank does not Exist");
		}
	}
	public Bank getBankdetails(int id)
	{
		EntityManager entityManager=getEntityManager();
		return entityManager.find( Bank.class,  id);
	}
	public List< Bank> getAllBankDetails()
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("Select b from Bank b ");
		return query.getResultList();
	}
}
