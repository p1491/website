package com.example.EmployeeManagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Employee Management",version="1.0",description="An API used for Employee Management."))


public class EmployeeManagment {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagment.class, args);
	}

}
