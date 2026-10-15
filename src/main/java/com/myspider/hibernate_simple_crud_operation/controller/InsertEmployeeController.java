package com.myspider.hibernate_simple_crud_operation.controller;

import java.time.LocalDate;

import com.myspider.hibernate_simple_crud_operation.dao.EmployeeDao;
import com.myspider.hibernate_simple_crud_operation.dto.Employee;

public class InsertEmployeeController {
	public static void main(String[] args) {
	EmployeeDao dao = new EmployeeDao();
	
	Employee employee = new Employee();
	
	employee.setId(6356);
	employee.setName("Siya");
	employee.setEmail("siya098@gmail.com");
	employee.setPhone(9875645606l);
	employee.setDoj(LocalDate.parse("2026-09-09"));
	
	dao.saveEmployeeDao(employee);
	dao.updateEmployeeByEmployeeIdDao(6355 , "Sonam" , 2345575891l);
	dao.deleteEmployeeByEmployeeIdDao(6356);
	
	}
}
