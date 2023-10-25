package com.example.EmployeeManagment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagment.entity.Compliance;
import com.example.EmployeeManagment.entity.Department;

@Service
public interface DepartmentService {
	public List<Department> findAll();
	
	public Department findById(int theId);
	
	public int getDepartmentCount();
	
	public void save(Department theDepartment);
	
	public void deleteById(int theId);	
}
