package com.example.EmployeeManagment.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagment.entity.Employee;

@Service
public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);	
	
	public int getEmployeeCount();
	
}

