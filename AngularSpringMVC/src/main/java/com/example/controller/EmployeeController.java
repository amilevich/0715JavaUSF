package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeServImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServImpl empService;
	
	//@CrossOrigin annotation is used to handle the request
	//from a different origin
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(value="/getemployees")
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployee();
	}
}
