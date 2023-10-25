package com.example.EmployeeManagment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagment.entity.Compliance;

public interface ComplianceRepository  extends JpaRepository<Compliance, Integer> {

	// that's it ... no need to write any code LOL!
	
}
