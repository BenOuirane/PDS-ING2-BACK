package com.application.aled.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptions")
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "objects")
	private Objects[] objects;

	@Column(name = "services")
	private Services[] services;

	@Column(name = "price")
	private int price;

	public Subscription() {

	}

	public Subscription(String name, Objects[] objects, Services[] services, int price) {
		super();
		this.name = name;
		this.objects = objects;
		this.services = services;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Objects[] getObject() {
		return objects;
	}

	public void setObject(Objects[] objects) {
		this.objects = objects;
	}

	public Services[] getService() {
		return services;
	}

	public void setService(Services[] services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", name=" + name + ", price=" + price + ", object=" + Arrays.toString(objects)
				+ ", service=" + Arrays.toString(services) + "]";
	}

}