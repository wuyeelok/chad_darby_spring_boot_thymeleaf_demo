package com.luv2code.springboot.thymeleafdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@SpringBootApplication
public class ThymeleafdemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThymeleafdemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

	// Testing only, create data in DB when server start, see
	// application.properties: createDatabaseIfNotExist=true
	// application.properties: spring.jpa.hibernate.ddl-auto
	// Reference: https://attacomsian.com/blog/spring-data-jpa-one-to-many-mapping
	@Bean
	public CommandLineRunner dbDataInit(EmployeeRepository employeeRepository) {
		return (args) -> {

			// create dummy employee
			LOGGER.info("Start to drop and create dummy employee for every build...");
			employeeRepository.save(new Employee("Leslie", "Andrews", "leslie@luv2code.com"));
			employeeRepository.save(new Employee("Emma", "Baumgarten", "emma@luv2code.com"));
			employeeRepository.save(new Employee("Avani", "Gupta", "avani@luv2code.com"));
			employeeRepository.save(new Employee("Yuri", "Petrov", "yuri@luv2code.com"));
			employeeRepository.save(new Employee("Juan", "Vega", "juan@luv2code.com"));
			employeeRepository.save(new Employee("Tom", "Fisher", "tomfisher@luv2code.com"));

			// fetch all employee
			LOGGER.info("Employee found with findAll():");
			LOGGER.info("---------------------------");
			for (Employee employee : employeeRepository.findAll()) {
				LOGGER.info(employee.toString());
			}

		};
	}
}
