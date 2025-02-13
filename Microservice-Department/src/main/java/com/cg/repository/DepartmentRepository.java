package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
