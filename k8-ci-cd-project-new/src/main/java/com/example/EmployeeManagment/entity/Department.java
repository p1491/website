package com.example.EmployeeManagment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="departid", nullable=false)
	private int departid;
	
	@Column(name="departname")
	private String departname;

	
	public Department() {
		
		// TODO Auto-generated constructor stub
	}


	public Department(int departid, String departname) {
		super();
		this.departid = departid;
		this.departname = departname;
	}


	public int getDepartid() {
		return departid;
	}


	public void setDepartid(int departid) {
		this.departid = departid;
	}


	public String getDepartname() {
		return departname;
	}


	public void setDepartname(String departname) {
		this.departname = departname;
	}

	@Override
	public String toString() {
		return "Department [departid=" + departid + ", departname=" + departname + "]";
	}
}
