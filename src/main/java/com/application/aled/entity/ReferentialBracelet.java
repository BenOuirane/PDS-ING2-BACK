/**
 * 
 */
package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.jmx.snmp.Timestamp;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

// add table attributs
@Entity
@Table(name = "ReferentialBracelet")
public class ReferentialBracelet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "Name")
	private String nameBracelet;
	
	@Column(name = "Brand")
	private String brandBracelet;
	
	@Column(name = "WIPDate")
	private Timestamp wipDate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameBracelet() {
		return nameBracelet;
	}

	public void setNameBracelet(String nameBracelet) {
		this.nameBracelet = nameBracelet;
	}

	public String getBrandBracelet() {
		return brandBracelet;
	}

	public void setBrandBracelet(String brandBracelet) {
		this.brandBracelet = brandBracelet;
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

	public boolean isOptionWaterProofYN() {
		return optionWaterProofYN;
	}

	public void setOptionWaterProofYN(boolean optionWaterProofYN) {
		this.optionWaterProofYN = optionWaterProofYN;
	}

	public boolean isOptioncardiacFrequency() {
		return optioncardiacFrequency;
	}

	public void setOptioncardiacFrequency(boolean optioncardiacFrequency) {
		this.optioncardiacFrequency = optioncardiacFrequency;
	}

	public boolean isOptionGPS() {
		return optionGPS;
	}

	public void setOptionGPS(boolean optionGPS) {
		this.optionGPS = optionGPS;
	}

	@Column(name = "UPDate")
	private Timestamp upDate;
	
	@Column(name = "Waterproof")
	private boolean optionWaterProofYN;
	
	@Column(name = "CardiacFrequency")
	private boolean optioncardiacFrequency;
	
	@Column(name = "GPS")
	private boolean optionGPS;

	public ReferentialBracelet(String id, String nameBracelet, String brandBracelet, Timestamp wipDate,
			Timestamp upDate, boolean optionWaterProofYN, boolean optioncardiacFrequency, boolean optionGPS) {
		super();
		this.id = id;
		this.nameBracelet = nameBracelet;
		this.brandBracelet = brandBracelet;
		this.wipDate = wipDate;
		this.upDate = upDate;
		this.optionWaterProofYN = optionWaterProofYN;
		this.optioncardiacFrequency = optioncardiacFrequency;
		this.optionGPS = optionGPS;
	}

	@Override
	public String toString() {
		return "ReferentialBracelet [id=" + id + ", nameBracelet=" + nameBracelet + ", brandBracelet=" + brandBracelet
				+ ", wipDate=" + wipDate + ", upDate=" + upDate + ", optionWaterProofYN=" + optionWaterProofYN
				+ ", optioncardiacFrequency=" + optioncardiacFrequency + ", optionGPS=" + optionGPS + "]";
	}

	
}
