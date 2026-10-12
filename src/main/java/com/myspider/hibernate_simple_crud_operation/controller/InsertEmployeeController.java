package com.myspider.hibernate_simple_crud_operation.controller;

import java.time.LocalDate;

import com.myspider.hibernate_simple_crud_operation.dao.EmployeeDao;
import com.myspider.hibernate_simple_crud_operation.dto.Employee;

public class InsertEmployeeController {
	public static void main(String[] args) {
	EmployeeDao dao = new EmployeeDao();
	
	Employee employee = new Employee();
	
	employee.setId(6352);
	employee.setName("Shradha");
	employee.setEmail("shradha456@gmail.com");
	employee.setPhone(4563987423l);
	employee.setDoj(LocalDate.parse("2026-10-22"));
	
	dao.saveEmployeeDao(employee);
	}
}
