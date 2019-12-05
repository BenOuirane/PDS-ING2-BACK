package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "ReferentialMeasure")
public class ReferentialMeasure {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long RefMeasure;

	@Column(name = "RefMeasure")
	private String refMeasure;

	@Column(name = "TypeMeasure")
	private String typeMeasure;
	
	@Column(name = "LevelMeasure")
	private String LevelMeasure;
	
	@Column(name= "WIPDate")
	private String wipDate;
	
	@Column(name= "UPDate")
	private String upDate;

	

	@Override
	public String toString() {
		return "ReferentialMeasure [RefMeasure=" + RefMeasure + ", refMeasure=" + refMeasure + ", typeMeasure="
				+ typeMeasure + ", LevelMeasure=" + LevelMeasure + ", wipDate=" + wipDate + ", upDate=" + upDate + "]";
	}

	public void setRefMeasure(long refMeasure) {
		RefMeasure = refMeasure;
	}

	public String getRefMeasure() {
		return refMeasure;
	}

	public void setRefMeasure(String refMeasure) {
		this.refMeasure = refMeasure;
	}

	public String getTypeMeasure() {
		return typeMeasure;
	}

	public void setTypeMeasure(String typeMeasure) {
		this.typeMeasure = typeMeasure;
	}

	public String getLevelMeasure() {
		return LevelMeasure;
	}

	public void setLevelMeasure(String levelMeasure) {
		LevelMeasure = levelMeasure;
	}

	public String getWipDate() {
		return wipDate;
	}

	public void setWipDate(String wipDate) {
		this.wipDate = wipDate;
	}

	public String getUpDate() {
		return upDate;
	}

	public void setUpDate(String upDate) {
		this.upDate = upDate;
	}
}
