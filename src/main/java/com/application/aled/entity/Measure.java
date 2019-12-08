package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Measure")
public class Measure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdMeasure")
	private long id;

	@Column(name = "CSleep")
	private String countSleep;

	@Column(name = "CCardiacFrequency")
	private String countCardiacFrequency;

	@Column(name = "CWaterResistance")
	private String countWaterResistance;

	@Column(name = "CPaths")
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

	@Column(name = "CDistance")
	private String countDistance;

	@Column(name = "CRespiratoryRate")
	private String countRespiratoryRate;

	@Column(name = "CExpiratoryFlowRate")
	private String countExpiratoryFlowRate;

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

	@Column(name = "COxygenSaturation")
	private String countOxygenSaturation;

	@Column(name = "CBodyTemperature")
	private String countBodyTemperature;

}
