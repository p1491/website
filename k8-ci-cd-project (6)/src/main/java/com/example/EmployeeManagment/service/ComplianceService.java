package com.example.EmployeeManagment.service;

	import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagment.entity.Compliance;
import com.example.EmployeeManagment.entity.Department;
import com.example.EmployeeManagment.entity.StatusReport;
	
	@Service
	public interface ComplianceService {
		
		 public List<Compliance> findAll();
		 public Compliance findById(int theId);	
		 public Compliance createRL(Compliance theCompliance);	   
	     public Compliance getAllRL(int id);
	     public void deleteById(int theId);
		public void save(Compliance theCompliance);	
	    

		//StatusReport createStatusReport(StatusReport statusReport);

		//List<StatusReport> getAllStatusReport();
   
	}