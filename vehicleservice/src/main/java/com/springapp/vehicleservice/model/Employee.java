package com.springapp.vehicleservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int employeeId;
	@Column(name = "employer_email")
	private String employerEmail;
	@Column(name = "emp_name")
	private String employeeName;
	@Column(name = "emp_email", unique = true)
	private String employeeEmail;
	@Column(name = "pass")
	private String password;
	@Column(name = "ph_no")
	private String contactNo;

	public Employee() {

	}

	public Employee(int employeeId, String employerEmail, String employeeName, String employeeEmail, String password,
			String contactNo) {
		super();
		this.employeeId = employeeId;
		this.employerEmail = employerEmail;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.password = password;
		this.contactNo = contactNo;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployerEmail() {
		return employerEmail;
	}

	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employerEmail=" + employerEmail + ", employeeName="
				+ employeeName + ", employeeEmail=" + employeeEmail + ", password=" + password + ", contactNo="
				+ contactNo + "]";
	}

}
