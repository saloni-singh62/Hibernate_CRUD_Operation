package com.myspider.hibernate_simple_crud_operation.controller;

import com.myspider.hibernate_simple_crud_operation.dao.EmployeeDao;
import com.myspider.hibernate_simple_crud_operation.dto.Employee;

public class GetEmployeeByIdController {
	public static void main(String[] args) {
		Employee employee = new EmployeeDao().getEmployeeByIdDao(6352);
		
		if(employee != null) {
			System.out.println(employee);
		}else {
			System.out.println("Given emp ID is NOT found");
		}
	}
}
//find() --> to fetch the data
