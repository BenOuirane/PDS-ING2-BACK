package com.application.aled.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="referentialMeasure")
@Entity
@Table(name = "referential_measure")
public class ReferentialMeasure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_measure")
	private String refMeasure;

	@Column(name = "type_measure")
	private String typeMeasure;

	@Column(name = "level_measure")
	private String LevelMeasure;

	@Column(name = "wip_date")
	private Timestamp wipDate;

	@Column(name = "up_date")
	private Timestamp upDate;

	@Override
	public String toString() {
		return "ReferentialMeasure [RefMeasure=" + refMeasure + ", refMeasure=" + refMeasure + ", typeMeasure="
				+ typeMeasure + ", LevelMeasure=" + LevelMeasure + ", wipDate=" + wipDate + ", upDate=" + upDate + "]";
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

	public Timestamp getWipDate() {
		return wipDate;
	}

	public void setWipDate(Timestamp wipDate) {
		this.wipDate = wipDate;
	}

	public Timestamp getUpDate() {
		return upDate;
	}

	public void setUpDate(Timestamp upDate) {
		this.upDate = upDate;
	}
}
