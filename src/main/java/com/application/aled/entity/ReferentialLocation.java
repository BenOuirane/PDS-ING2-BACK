package com.application.aled.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/* 
	This entity will be the table of Referential Position
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/


@Entity
@Table(name = "location")
public class ReferentialLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_location", nullable = false, unique= true)
	private int id;

	public ReferentialLocation(int id, String name, LocalDateTime wipDate, LocalDateTime upDate) {
	
		this.id = id;
		this.name = name;
		this.wipDate = wipDate;
		this.upDate = upDate;
	}

	public ReferentialLocation() {}
	@Override
	public String toString() {
		return "ReferentialLocation [id=" + id + ", name=" + name + ", wipDate=" + wipDate + ", upDate=" + upDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getWipDate() {
		return wipDate;
	}

	public void setWipDate(LocalDateTime wipDate) {
		this.wipDate = wipDate;
	}

	public LocalDateTime getUpDate() {
		return upDate;
	}

	public void setUpDate(LocalDateTime upDate) {
		this.upDate = upDate;
	}

	@Column(name = "name")
	private String name;

	@Column(name = "wip_date")
	private LocalDateTime wipDate;

	@Column(name = "up_date")
	private LocalDateTime upDate;
	
}