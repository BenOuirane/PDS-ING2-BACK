package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.application.aled.controller.exception.CustomHandler;

@Entity
@Table(name = "services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "typeService")
	private String typeService;

	public Services() {
	}

	public Services(String name, String typeService) {
		super();
		this.name = name;
		this.typeService = typeService;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		for (TypeService serv : TypeService.values()) {
			if (typeService.equals(serv.name())) {
				this.typeService = typeService;
				return;
			}
		}
		throw new CustomHandler("Type Service not respected");
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", typeService=" + typeService + "]";
	}

}