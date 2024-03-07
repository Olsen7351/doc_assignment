package com.doc.assignmentbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackages = "com.doc.assignmentbackend.DAO")
@EntityScan(basePackages = "com.doc.assignmentbackend.Model")
public class AssignmentbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentbackendApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

}
