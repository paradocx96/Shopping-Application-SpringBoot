package com.shoppingapplication.models;

import javax.persistence.*;

//Create new table called roles
@Entity
@Table(name = "roles")
public class Role {
	
	//role id is set to auto generate
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	
	//Default constructor 
	public Role() {

	}

	//Overloaded constructor
	public Role(ERole name) {
		this.name = name;
	}

	//Getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}