package com.gobi.edu.vo;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1112167672924364484L;
	
	private long studentId;
	
	private String firstName;
	
	private String address;

	public long getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", address=" + address + "]";
	}
	
}
