package com.example.EmployeeManagment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagment.entity.Department;


public interface  DepartmentRepository extends JpaRepository<Department, Integer>{

}
