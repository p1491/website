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
@Table(name="statusreport")
public class StatusReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="statusId")
	private int statusId;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="details")
	private String details;

	@Column(name="createDate")
	LocalDate createDate;
	
	
	@Column(name="userId")
	private int userId;
	
	@OneToOne
    public Compliance compliance;

	@OneToOne
    private Department department;
	

	public StatusReport() {
				// TODO Auto-generated constructor stub
	}

	public StatusReport(int statusId, String comments, String details, LocalDate createDate, int userId,
			Compliance compliance, Department department) {
		super();
		this.statusId = statusId;
		this.comments = comments;
		this.details = details;
		this.createDate = createDate;
		this.userId = userId;
		this.compliance = compliance;
		this.department = department;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Compliance getCompliance() {
		return compliance;
	}

	public void setCompliance(Compliance compliance) {
		this.compliance = compliance;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "StatusReport [statusId=" + statusId + ", comments=" + comments + ", details=" + details
				+ ", createDate=" + createDate + ", userId=" + userId + ", compliance=" + compliance + ", department="
				+ department + "]";
	}

}
			