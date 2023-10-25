package com.example.EmployeeManagment.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagment.entity.Department;
import com.example.EmployeeManagment.service.DepartmentService;


@RestController
@RequestMapping("/dept")
public class DepartmentRestController {

	private DepartmentService departmentService;
	
	@Autowired
	public DepartmentRestController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	@GetMapping("/department")
	public List<Department> findAll() {
		return departmentService.findAll();
	}

	
	@GetMapping("/department/{deptid}")
	public Department getDepartment(@PathVariable int deptid) {
		
		Department theDepartment = departmentService.findById(deptid);
		
		if (theDepartment == null) {
			throw new RuntimeException("Department id not found - " + deptid);
		}
		
		return theDepartment;
	}
	
	
	
	@PostMapping("/department")
	public Department addDepartment(@RequestBody Department theDepartment) {
		
		theDepartment.setDepartid(0);
		
		departmentService.save(theDepartment);
		
		return theDepartment;
	}
	
	@PutMapping("/department")
	public Department updateDepartment(@RequestBody Department theDepartment) {
		
		departmentService.save(theDepartment);
		
		return theDepartment;
	}
	
	@DeleteMapping("/department/{departid}")
	public String deleteDepartment(@PathVariable int departid) {
		
		Department tempDepartment = departmentService.findById(departid);
		
		// throw exception if null
		
		if (tempDepartment == null) {
			throw new RuntimeException("Department id not found - " + departid);
		}
		
		departmentService.deleteById(departid);
		
		return "Deleted Department id - " + departid;
	}
	@GetMapping("/getDepartmentCount")
    public int getDepartmentCount() {
     
     return departmentService.getDepartmentCount();
 }
}
