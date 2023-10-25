package com.example.EmployeeManagment.rest;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
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

import com.example.EmployeeManagment.entity.Compliance;
import com.example.EmployeeManagment.entity.Department;
import com.example.EmployeeManagment.service.ComplianceService;

@RestController
@RequestMapping("/comp")
public class ComplianceRestController {
	
	private ComplianceService complianceService;
	@Autowired 
	public ComplianceRestController(ComplianceService theComplianceService) {
		complianceService = theComplianceService;

	}

	@GetMapping("/compliance")
	public List<Compliance> findAll() {

		return complianceService.findAll();

	}
	@PostMapping("/compliance")
	public Compliance addCompliance(@RequestBody Compliance theCompliance) {
		
		theCompliance.setComplianceid(0);
		
		complianceService.createRL(theCompliance);
		
		return theCompliance;
	}
	@GetMapping("/compliance/{id}")
	public Compliance getById(@PathVariable int id) {
	    return complianceService.getAllRL(id);
	}
	@PutMapping("/compliance")
	public Compliance updateCompliance(@RequestBody Compliance theCompliance) {
		
		complianceService.save(theCompliance);
		
		return theCompliance;
	}
	@DeleteMapping("/compliance/{id}")
	public String deleteDepartment(@PathVariable int id) {
		
		Compliance tempcompliance = complianceService.findById(id);
		
		// throw exception if null
		
		if (tempcompliance == null) {
			throw new RuntimeException("Department id not found - " + id);
		}
		
		complianceService.deleteById(id);
		
		return "Deleted Compliance id - " + id;
	}
}