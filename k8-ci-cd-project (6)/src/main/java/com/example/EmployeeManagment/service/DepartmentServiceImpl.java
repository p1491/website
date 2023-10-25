package com.example.EmployeeManagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagment.dao.DepartmentRepository;
import com.example.EmployeeManagment.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	DepartmentRepository departmentRepository;
	
	@Autowired	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public Department findById(int theId) {
		Optional<Department> result = departmentRepository.findById(theId);
		
		Department theDepartment = null;
		
		if (result.isPresent()) {
			theDepartment = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Projects id - " + theId);
		}
		
		return theDepartment;
	}

	@Override
	public void save(Department theDepartment) {
		departmentRepository.save(theDepartment);
	}

	@Override
	public void deleteById(int theId) {
		departmentRepository.deleteById(theId);
	}
	
	@Override
	public int getDepartmentCount() {
		return (int)departmentRepository.count();
	}
}
