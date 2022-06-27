package com.nt.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_info")
public class Student_info {

	@Id
	@Column(name="StudentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	@Column(name="Name")
	private String name;
	@Column(name="Department")
	private String department;
	@Column(name="Country")
	private String country;


	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDapartment() {
		return getDapartment();
	}

	public void setDapatment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Student_info [studentId=" + studentId + ", name=" + name + ", department=" + department + ", country="
				+ country + "]";
	}
	
}
