package com.ty.many_to_one.dao;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import many_to_one_Bank.dto.Bank;
import many_to_one_Bank.dto.Branch;

public class BranchCRUD {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory( "venu");
		return entityManagerFactory.createEntityManager();
	}
	public void savebranch(int id, Branch branch)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Bank bank=entityManager.find(Bank.class,id );
		branch.setId(id);
		branch.setBank(bank);
		entityTransaction.begin();
		entityManager.persist( branch);
		entityManager.persist(branch.getBank());
		entityTransaction.commit();
	}
	public void updateBranch(int id, Branch branch)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		branch=entityManager.find(Branch.class,id);
		if(branch !=null)
		{
			branch.setBank( branch.getBank());
			branch.setId(id);
			entityTransaction.begin();
			entityManager.merge( branch);
			entityTransaction.commit();
		}
		else {
			System.out.println("The Branch does not Exist");
		}
	}
	
	public void deleteBranch(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find( Branch.class, id);
		if(branch !=null)
		{
			branch.setId(id);
			entityTransaction.begin();
			entityManager.remove( branch);
			entityTransaction.commit();
		}
		else {
			System.out.println("The Branch does not Exist");
		}
	}
	public Branch getBranchdetails(int id)
	{
		EntityManager entityManager=getEntityManager();
		return entityManager.find( Branch.class,  id);
	}
	public List< Branch> getBranch()
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Query query=entityManager.createQuery("Select b from Branch b ");
		return query.getResultList();
	}
}
