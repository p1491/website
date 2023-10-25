package com.example.EmployeeManagment.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagment.dao.ComplianceRepository;
import com.example.EmployeeManagment.dao.StatusReportRepository;
import com.example.EmployeeManagment.entity.Compliance;
import com.example.EmployeeManagment.entity.Department;

@Service
public class ComplianceServiceImpl  implements ComplianceService{

    @Autowired
    private ComplianceRepository complianceRepository;
    @Autowired
    private StatusReportRepository statusReportRepository;

    @Override
    public Compliance createRL(Compliance compliance) {
        complianceRepository.save(compliance);
        return compliance;
    }

    @Override
    public List<Compliance> findAll() {
        return complianceRepository.findAll();
    }

   @Override
    public Compliance getAllRL(int id) {
        Compliance compliance = null;
        Optional<Compliance> optionalCompliance = complianceRepository.findById(id);
        if (optionalCompliance.isPresent()) {
            compliance = optionalCompliance.get();
        }
        return compliance;
    }
  
   @Override
	public Compliance findById(int theId) {
		Optional<Compliance> result = complianceRepository.findById(theId);
		
		Compliance theCompliance = null;
		
		if (result.isPresent()) {
			theCompliance = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find Projects id - " + theId);
		}
		
		return theCompliance;
	}
   public void deleteById(int theId) {
	   complianceRepository.deleteById(theId);
	}	
   @Override
	public void save(Compliance theCompliance) {
	   complianceRepository.save(theCompliance);
	}

	}
