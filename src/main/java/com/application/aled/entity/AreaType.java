package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name="AreaType")
@Table(name ="area_type")
public class AreaType {

	@Id
	@Column(name = "id")
	private int id_area_type;
	
	public int getId_area_type() {
		return id_area_type;
	}

	public void setId_area_type(int id_area_type) {
		this.id_area_type = id_area_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name")
	private String name; 
	
	
	//TODO Add PF and FK  
	
}
