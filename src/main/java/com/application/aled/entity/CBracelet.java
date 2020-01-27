/**
 * 
 */
package com.application.aled.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Entity
@Table(name = "cbracelet")
public class CBracelet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "date", nullable = false)
	private LocalDateTime date ;
	
	//@Column(name = "current_location", nullable = false)
	//private CurrentLocation currentlocation;
	
	public CBracelet(int id, LocalDateTime date) {
	
		this.id = id;
		this.date = date;
	}
	public CBracelet() {}

	@Override
	public String toString() {
		return "CBracelet [id=" + id + ", date=" + date + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}




	

}
