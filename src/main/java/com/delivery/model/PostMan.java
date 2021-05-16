package com.delivery.model;

import javax.persistence.*;

// Declare annotations for table name
@Entity
@Table(name = "postman")
public class PostMan {

	// Declare variables with annotations for table columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "orderid")
    private String orderid;

    @Column(name = "price")
    private String price;

    @Column(name = "status")
    private String status;

	// Implement default constructor
    public PostMan() {
		super();
	}

	// Implement overload constructor
	public PostMan(String orderid, String price, String status) {
		super();
		this.orderid = orderid;
		this.price = price;
		this.status = status;
	}

	// Implement Getter & Setter for variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}