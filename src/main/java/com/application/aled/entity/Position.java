package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Position")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPosition")
	private long id;

	@Column(name = "Latitude")
	private long lat_pos;

	@Column(name = "Longitude")
	private long long_pos;

	@Column(name = "RefPosition")
	private long ref_pos;

	@Column(name = "Date")
	private long date_pos;

	public long getRef_pos() {
		return ref_pos;
	}

	public void setRef_pos(long ref_pos) {
		this.ref_pos = ref_pos;
	}

	public long getDate_pos() {
		return date_pos;
	}

	public void setDate_pos(long date_pos) {
		this.date_pos = date_pos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getLong_pos() {
		return long_pos;
	}

	public void setLong_pos(long long_pos) {
		this.long_pos = long_pos;
	}

	public long getLat_pos() {
		return lat_pos;
	}

	public void setLat_pos(long lat_pos) {
		this.lat_pos = lat_pos;
	}

}
