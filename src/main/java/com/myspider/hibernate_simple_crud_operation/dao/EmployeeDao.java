package com.myspider.hibernate_simple_crud_operation.dao;

import com.myspider.hibernate_simple_crud_operation.dto.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeDao {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	public Employee saveEmployeeDao(Employee employee){
		
	EntityManager em =	emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		
		try {
			if(employee == null) {
				return null; //back to the column 
			}
			et.begin();
			em.persist(employee); // employee is entity class this will execute insert Query.....
			et.commit();
			
			return employee;
		}
		catch(Exception e){
			if(et.isActive()) {
				et.rollback();
			}e.printStackTrace();
			return null;
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
	
	public Employee getEmployeeByIdDao(int employeeId) {
		EntityManager em = emf.createEntityManager();
		try {
		Employee employee = em.find(Employee.class, employeeId); // find() method perform resultSet operation
		return employee;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
	
	public Employee updateEmployeeByEmployeeIdDao(int employeeId , String name, Long phone) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		try {
		Employee employee = em.find(Employee.class, employeeId); // find() method perform resultSet operation
		if(employee != null) {
			
			employee.setName(name);
			employee.setPhone(phone);
			
			et.begin();
			
			em.merge(employee);
			
			et.commit();
			
			return employee;
		}
		
		return null;
		}
		catch(Exception e) {
			et.isActive();
			et.rollback();
			e.printStackTrace();
			return null;
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
	
	public boolean deleteEmployeeByEmployeeIdDao(int employeeId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et =em.getTransaction();
		try {
			
			
		Employee employee = em.find(Employee.class, employeeId); // find() method perform resultSet operation
		if(employee != null) {
			et.begin();
			
			em.remove(employee);
			
			et.commit();
			return true;
		}
		et.rollback();
		return false;
		}
		catch(Exception e) {
			et.isActive();
			et.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
}
