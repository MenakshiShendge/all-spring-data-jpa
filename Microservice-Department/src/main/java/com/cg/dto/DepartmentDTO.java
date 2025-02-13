package com.cg.dto;


import com.cg.entity.Department;


public class DepartmentDTO {
	
	private int id;
	private String dname;
	
	
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public DepartmentDTO(int id, String dname) {
		super();
		this.id = id;
		this.dname = dname;
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	// Optionally, you can add methods to convert from Entity to DTO and vice versa.
    public static DepartmentDTO fromEntity(Department department) {
        return new DepartmentDTO(department.getId(), department.getDname());
    }
 
    public Department toEntity() {
        return new Department(this.id, this.dname);
    }
	

}
