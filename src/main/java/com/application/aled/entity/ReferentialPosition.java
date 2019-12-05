package com.application.aled.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ReferentialPosition")
public class ReferentialPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "RefPosition")
	private String id;
	
	@Column(name= "Name")
	private String name;
	
	@Column(name= "Surface")
	private Double surface;
	
	@Column(name= "Emplacement")
	private String emplacementPosition;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "ReferentialPosition [id=" + id + ", name=" + name + ", surface=" + surface + ", emplacement="
				+ emplacementPosition + "]";
	}

	public ReferentialPosition(String id, String name, Double surface, String emplacement) {
		super();
		this.id = id;
		this.name = name;
		this.surface = surface;
		this.emplacementPosition = emplacement;
	}
	
}