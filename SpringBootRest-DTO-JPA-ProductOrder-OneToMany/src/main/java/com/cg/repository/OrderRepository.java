package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Orders;
@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
