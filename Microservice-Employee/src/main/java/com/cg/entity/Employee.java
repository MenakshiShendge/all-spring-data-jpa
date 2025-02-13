package com.cg.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MSEmployee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ename")
	private String ename;
	
	@Column(name = "esalary")
	private double esalary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String ename, double esalary) {
		super();
		this.id = id;
		this.ename = ename;
		this.esalary = esalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", esalary=" + esalary + "]";
	}
	
	
}
