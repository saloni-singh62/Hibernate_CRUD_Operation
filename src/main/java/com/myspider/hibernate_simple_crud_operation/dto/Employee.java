package com.myspider.hibernate_simple_crud_operation.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {
	@Id //generate primary key make unique id
	private int id;
	private String name;
	@Column(unique = true , nullable = false , length = 20) // for extra validation
	private String email;
	@Column(unique = true , nullable = false , length = 12)
	private long phone;
	private LocalDate doj;
	@CreationTimestamp  //its automatically save booking date and time 
	private LocalDate registrationDate;
}
