package com.application.aled.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/* 
	This entity will be the table of Referential Position
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/


@XmlRootElement(name="referentialPosition")
@Entity
@Table(name = "referential_position")
public class ReferentialPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_position")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surface")
	private Double surface;

	public ReferentialPosition(int id, String name, Double surface, String emplacementPosition, LocalDateTime wipDate,
			LocalDateTime upDate) {
		super();
		this.id = id;
		this.name = name;
		this.surface = surface;
		this.emplacementPosition = emplacementPosition;
		this.wipDate = wipDate;
		this.upDate = upDate;
	}

	@Column(name = "emplacement")
	private String emplacementPosition;

	@Column(name = "wip_date")
	private LocalDateTime wipDate;

	@Column(name = "up_date")
	private LocalDateTime upDate;
	
	public String getEmplacementPosition() {
		return emplacementPosition;
	}

	public void setEmplacementPosition(String emplacementPosition) {
		this.emplacementPosition = emplacementPosition;
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

	public Double getSurface() {
		return surface;
	}

	public void setSurface(Double surface) {
		this.surface = surface;
	}

	public String getEmplacement() {
		return emplacementPosition;
	}

	public void setEmplacement(String emplacement) {
		this.emplacementPosition = emplacement;
	}

	@Override
	public String toString() {
		return "ReferentialPosition [id=" + id + ", name=" + name + ", surface=" + surface + ", emplacementPosition="
				+ emplacementPosition + ", wipDate=" + wipDate + ", upDate=" + upDate + "]";
	}

	public ReferentialPosition(int id, String name, Double surface, String emplacement) {
		super();
		this.id = id;
		this.name = name;
		this.surface = surface;
		this.emplacementPosition = emplacement;
	}

}