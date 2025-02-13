package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	public List<Products> findByPname(String pname);
	
	@Query("SELECT COUNT(p) FROM Products p WHERE p.pname = :pname")
    Long countByProductName(String pname);

}
