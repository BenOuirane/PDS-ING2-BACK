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
	
	@Column(name = "name")
	private String name; 
	
	
	//TODO Add PF and FK  
	
}
