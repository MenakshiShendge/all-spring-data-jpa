package com.cg.dto;

import java.util.Date;

import com.cg.entity.Orders;
import com.cg.entity.Products;

public class OrderDTO {
	
	private int id;
	private Date odate;
	
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(int id, Date odate) {
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
	
	// Optionally, you can add methods to convert from Entity to DTO and vice versa.
    public static OrderDTO fromEntity(Orders orders) {
        return new OrderDTO(orders.getId(), orders.getOdate());
    }
 
    public Orders toEntity() {
        return new Orders(this.id, this.odate);
    }
	

}
