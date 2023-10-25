package com.example.EmployeeManagment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
