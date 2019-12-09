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
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;



/**
 * @author ISMAIL EL HAMMOUD
 *
 */

// add table attributes

@XmlRootElement(name="referentialBracelet")
@Entity
@Table(name = "referential_bracelet")
public class ReferentialBracelet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "name")
	private String nameBracelet;

	@Column(name = "brand")
	private String brandBracelet;

	@Column(name = "wip_date")
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

	@Column(name = "up_date")
	private Timestamp upDate;

	@Column(name = "is_waterproof")
	private boolean optionWaterProofYN;

	@Column(name = "is_cardiacfrequency")
	private boolean optioncardiacFrequency;

	@Column(name = "is_gps")
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
