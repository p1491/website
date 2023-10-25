package com.example.EmployeeManagment.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compliance")
public class Compliance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="complianceid")
	private int complianceid;
	
	@Column(name="rlType")
	private String rlType;
	
	@Column(name="details")
	private String details;

	@Column(name="createDate")
	LocalDate createDate;
	
	
	@Column(name="empCount")
	private int empCount;
	
	@Column(name="stsCount")
	private int stsCount;
	
	@Column(name="status")
	private String status;
	
	@OneToOne
    private Department department;
	

	public Compliance() {
	
		// TODO Auto-generated constructor stub
	}

	public Compliance(int complianceid, String rlType, String details, LocalDate createDate, int empCount, int stsCount,
			String status, Department department) {
		super();
		this.complianceid = complianceid;
		this.rlType = rlType;
		this.details = details;
		this.createDate = createDate;
		this.empCount = empCount;
		this.stsCount = stsCount;
		this.status = status;
		this.department = department;
	}

	public int getComplianceid() {
		return complianceid;
	}

	public void setComplianceid(int complianceid) {
		this.complianceid = complianceid;
	}

	public String getRlType() {
		return rlType;
	}

	public void setRlType(String rlType) {
		this.rlType = rlType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}

	public int getStsCount() {
		return stsCount;
	}

	public void setStsCount(int stsCount) {
		this.stsCount = stsCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Compliance [complianceid=" + complianceid + ", rlType=" + rlType + ", details=" + details
				+ ", createDate=" + createDate + ", empCount=" + empCount + ", stsCount=" + stsCount + ", status="
				+ status + ", department=" + department + "]";
	}
		

	}