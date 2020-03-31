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
@RequestMapping("/employees")
public class EmployeeController {

	// Load employee data

	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {

		// Create employee
		Employee emp1 = new Employee(1, "JJ", "AAA", "jjaa@gmail.com");
		Employee emp2 = new Employee(2, "TTT", "XXXX", "tx@gmail.com");
		Employee emp3 = new Employee(3, "WW", "CCC", "wc@gmail.com");

		// Create the list
		this.theEmployees = new ArrayList<>();

		// Add to the list
		this.theEmployees.add(emp1);
		this.theEmployees.add(emp2);
		this.theEmployees.add(emp3);
	}

	// Add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// Add to the spring model
		theModel.addAttribute("employees", this.theEmployees);

		return "list-employees";
	}

}
