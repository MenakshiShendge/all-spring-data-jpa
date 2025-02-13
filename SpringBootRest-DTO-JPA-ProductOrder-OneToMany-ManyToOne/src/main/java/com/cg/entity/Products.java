package com.cg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productsManyToOneJPAbidirectional")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private  int id;
	
	@Column(name="pname", nullable =false)
 private  String pname;
	
	@Column(name="price", nullable = false)
 private  double price;
	
	//as join column is already mapped by order so make it as read only
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderID",insertable = false,updatable = false)
    private Orders orders;	

public Products() {
	this.id = 0;
	this.pname = "";
	this.price = 0.0;
}
public Products(int id, String pname, double price) {
	super();
	this.id = id;
	this.pname = pname;
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Product [id=" + id + ", pname=" + pname + ", price=" + price + "]";
}
public Orders getOrders() {
	return orders;
}
public void setOrders(Orders orders) {
	this.orders = orders;
}

 
 
}
