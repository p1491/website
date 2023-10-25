package com.example.EmployeeManagment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeManagment.entity.StatusReport;

@Repository
public interface StatusReportRepository extends JpaRepository<StatusReport,Integer> {
}
 