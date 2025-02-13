package com.cg.dto;


import com.cg.entity.Employee;


public class EmployeeDTO {
	
	private int id;
	private String ename;
	private double esalary;
	
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(int id, String ename, double esalary) {
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

	// Optionally, you can add methods to convert from Entity to DTO and vice versa.
    public static EmployeeDTO fromEntity(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getEname(),employee.getEsalary());
    }
 
    public Employee toEntity() {
        return new Employee(this.id, this.ename,this.esalary);
    }
	

}
