package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.jmx.snmp.Timestamp;


/* 
	This entity will be the table of Position
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/

@XmlRootElement(name="position")
@Entity
@Table(name = "position")
public class Position {
	
	public Position(String id, double lat_pos, double long_pos, String ref_pos, Timestamp date_pos) {
		super();
		this.id = id;
		this.lat_pos = lat_pos;
		this.long_pos = long_pos;
		this.ref_pos = ref_pos;
		this.date_pos = date_pos;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", lat_pos=" + lat_pos + ", long_pos=" + long_pos + ", ref_pos=" + ref_pos
				+ ", date_pos=" + date_pos + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_position")
	private String id;

	@Column(name = "latitude")
	private double lat_pos;

	@Column(name = "longitude")
	private double long_pos;

	@Column(name = "ref_position")
	private String ref_pos;

	@Column(name = "date")
	private Timestamp date_pos;

	public String getRef_pos() {
		return ref_pos;
	}

	public void setRef_pos(String ref_pos) {
		this.ref_pos = ref_pos;
	}

	public Timestamp getDate_pos() {
		return date_pos;
	}

	public void setDate_pos(Timestamp date_pos) {
		this.date_pos = date_pos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getLong_pos() {
		return long_pos;
	}

	public void setLong_pos(double long_pos) {
		this.long_pos = long_pos;
	}

	public double getLat_pos() {
		return lat_pos;
	}

	public void setLat_pos(double lat_pos) {
		this.lat_pos = lat_pos;
	}

}
