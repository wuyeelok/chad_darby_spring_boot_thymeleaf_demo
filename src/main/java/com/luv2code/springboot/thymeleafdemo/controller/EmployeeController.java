package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// Load employee data

	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {

		// Create employees
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
		Employee emp2 = new Employee(2, "John", "Wick", "john@luv2code.com");
		Employee emp3 = new Employee(3, "Steven", "Pit", "steven@luv2code.com");

		// Create the list
		theEmployees = new ArrayList<>();

		// Add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);

	}

	// Add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}

}
