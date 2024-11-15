package com.healthcare.healthcare_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthcareBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareBackendApplication.class, args);

		System.out.println("\n\nServer is Online...\n");
	}

}
