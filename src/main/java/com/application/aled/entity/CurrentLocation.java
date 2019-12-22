/**
 * 
 */
package com.application.aled.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Entity
@Table(name = "current_location")
public class CurrentLocation  implements Serializable {

	@Id
	@Column(name = "id_bracelet")
	private int id_bracelet;
	
	
	@Column(name = "date")
	private LocalDateTime date;
	
	
	@Column(name = "id_location")
	private int id_location;
	
	public CurrentLocation(int id_bracelet, LocalDateTime date, int id_location) {
		super();
		this.id_bracelet = id_bracelet;
		this.date = date;
		this.id_location = id_location;
	}
	public CurrentLocation(){}

	@Override
	public String toString() {
		return "CurrentLocation [id_bracelet=" + id_bracelet + ", date=" + date + ", id_location=" + id_location + "]";
	}

	public int getId_bracelet() {
		return id_bracelet;
	}

	public void setId_bracelet(int id_bracelet) {
		this.id_bracelet = id_bracelet;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getId_location() {
		return id_location;
	}

	public void setId_location(int id_location) {
		this.id_location = id_location;
	}

	
}
