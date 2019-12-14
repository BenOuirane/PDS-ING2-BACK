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
	This entity will be the table of Referential Measure
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/

@XmlRootElement(name="referentialMeasure")
@Entity
@Table(name = "referential_measure")
public class ReferentialMeasure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_measure", nullable = false)
	private int refMeasure;

	@Column(name = "type_measure")
	private String typeMeasure;

	@Column(name = "level_measure")
	private String LevelMeasure;

	@Column(name = "wip_date")
	private LocalDateTime wipDate;

	@Column(name = "up_date")
	private LocalDateTime upDate;

	@Override
	public String toString() {
		return "ReferentialMeasure [RefMeasure=" + refMeasure + ", refMeasure=" + refMeasure + ", typeMeasure="
				+ typeMeasure + ", LevelMeasure=" + LevelMeasure + ", wipDate=" + wipDate + ", upDate=" + upDate + "]";
	}

	public void setRefMeasure(int refMeasure) {
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
}
