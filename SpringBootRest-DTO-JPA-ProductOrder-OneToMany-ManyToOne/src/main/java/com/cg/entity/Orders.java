package com.cg.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderSOneTOManyJPAbidirectional")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "odate")
	private Date odate;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderID")
	private List<Products> productslist;

	public Orders() {
		this.id=0;
		this.odate=new Date();
	}

	public Orders(int id, Date odate) {
		super();
		this.id = id;
		this.odate = odate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOdate() {
		return odate;
	}

	public void setOdate(Date odate) {
		this.odate = odate;
	}
	

	public List<Products> getProductslist() {
		return productslist;
	}

	public void setProductslist(List<Products> productslist) {
		this.productslist = productslist;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", odate=" + odate + "]";
	}
	
	

}
