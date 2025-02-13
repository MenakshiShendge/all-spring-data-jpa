package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	public List<Products> findByPname(String pname);

}
