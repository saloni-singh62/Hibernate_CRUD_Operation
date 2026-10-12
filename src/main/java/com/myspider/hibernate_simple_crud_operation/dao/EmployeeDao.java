package com.myspider.hibernate_simple_crud_operation.dao;

import com.myspider.hibernate_simple_crud_operation.dto.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDao {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	public void saveEmployeeDao(Employee employee){
		
	EntityManager em =	emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		try {
			if(employee == null) {
				return; //back to the column 
			}
			et.begin();
			em.persist(employee); // employee is entity class this will execute insert Query.....
			et.commit();
		}
		catch(Exception e){
			if(et.isActive()) {
				et.rollback();
			}e.printStackTrace();
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
}
