package com.cg.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderjpa")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "odate")
	private Date odate;

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

	@Override
	public String toString() {
		return "Orders [id=" + id + ", odate=" + odate + "]";
	}
	
	

}
