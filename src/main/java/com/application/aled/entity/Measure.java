package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



/* 
	This entity will be the table of Measure
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/


@XmlRootElement(name="measure")
@Entity
@Table(name = "measure")
public class Measure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_measure")
	private long id;

	@Column(name = "count_sleep")
	private String countSleep;

	@Column(name = "count_cardiacfrequency")
	private String countCardiacFrequency;

	@Column(name = "count_waterresistance")
	private String countWaterResistance;

	@Column(name = "count_paths")
	private String countPaths;

	public Measure(long id, String countSleep, String countCardiacFrequency, String countWaterResistance,
			String countPaths, String countDistance, String countRespiratoryRate, String countExpiratoryFlowRate,
			String countOxygenSaturation, String countBodyTemperature) {
		super();
		this.id = id;
		this.countSleep = countSleep;
		this.countCardiacFrequency = countCardiacFrequency;
		this.countWaterResistance = countWaterResistance;
		this.countPaths = countPaths;
		this.countDistance = countDistance;
		this.countRespiratoryRate = countRespiratoryRate;
		this.countExpiratoryFlowRate = countExpiratoryFlowRate;
		this.countOxygenSaturation = countOxygenSaturation;
		this.countBodyTemperature = countBodyTemperature;
	}

	@Column(name = "count_distance")
	private String countDistance;

	@Column(name = "count_respiratoryrate")
	private String countRespiratoryRate;

	@Column(name = "count_expiratoryflowrate")
	private String countExpiratoryFlowRate;
	
	@Column(name = "count_oxygensaturation")
	private String countOxygenSaturation;

	@Column(name = "count_podytemperature")
	private String countBodyTemperature;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Measure [id=" + id + ", countSleep=" + countSleep + ", countCardiacFrequency=" + countCardiacFrequency
				+ ", countWaterResistance=" + countWaterResistance + ", countPaths=" + countPaths + ", countDistance="
				+ countDistance + ", countRespiratoryRate=" + countRespiratoryRate + ", countExpiratoryFlowRate="
				+ countExpiratoryFlowRate + ", countOxygenSaturation=" + countOxygenSaturation
				+ ", countBodyTemperature=" + countBodyTemperature + "]";
	}

	public String getCountSleep() {
		return countSleep;
	}

	public void setCountSleep(String countSleep) {
		this.countSleep = countSleep;
	}

	public String getCountCardiacFrequency() {
		return countCardiacFrequency;
	}

	public void setCountCardiacFrequency(String countCardiacFrequency) {
		this.countCardiacFrequency = countCardiacFrequency;
	}

	public String getCountWaterResistance() {
		return countWaterResistance;
	}

	public void setCountWaterResistance(String countWaterResistance) {
		this.countWaterResistance = countWaterResistance;
	}

	public String getCountPaths() {
		return countPaths;
	}

	public void setCountPaths(String countPaths) {
		this.countPaths = countPaths;
	}

	public String getCountDistance() {
		return countDistance;
	}

	public void setCountDistance(String countDistance) {
		this.countDistance = countDistance;
	}

	public String getCountRespiratoryRate() {
		return countRespiratoryRate;
	}

	public void setCountRespiratoryRate(String countRespiratoryRate) {
		this.countRespiratoryRate = countRespiratoryRate;
	}

	public String getCountExpiratoryFlowRate() {
		return countExpiratoryFlowRate;
	}

	public void setCountExpiratoryFlowRate(String countExpiratoryFlowRate) {
		this.countExpiratoryFlowRate = countExpiratoryFlowRate;
	}

	public String getCountOxygenSaturation() {
		return countOxygenSaturation;
	}

	public void setCountOxygenSaturation(String countOxygenSaturation) {
		this.countOxygenSaturation = countOxygenSaturation;
	}

	public String getCountBodyTemperature() {
		return countBodyTemperature;
	}

	public void setCountBodyTemperature(String countBodyTemperature) {
		this.countBodyTemperature = countBodyTemperature;
	}


}
