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

import java.time.LocalDateTime;



/**
 * @author ISMAIL EL HAMMOUD
 *
 */

/* 
	This entity will be the table of Referential Bracelet
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/
@XmlRootElement(name="referentialBracelet")
@Entity
@Table(name = "referential_bracelet")
public class ReferentialBracelet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "refbracelet", nullable = false)
	private long id;

	@Column(name = "name")
	private String nameBracelet;

	@Column(name = "brand")
	private String brandBracelet;

	@Column(name = "wip_date")
	private LocalDateTime wipDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	private LocalDateTime upDate;

	@Column(name = "is_waterproof")
	private boolean optionWaterProofYN;

	@Column(name = "is_cardiacfrequency")
	private boolean optioncardiacFrequency;

	@Column(name = "is_gps")
	private boolean optionGPS;

	public ReferentialBracelet(long id, String nameBracelet, String brandBracelet, LocalDateTime wipDate,
			LocalDateTime upDate, boolean optionWaterProofYN, boolean optioncardiacFrequency, boolean optionGPS) {
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

	public ReferentialBracelet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReferentialBracelet [id=" + id + ", nameBracelet=" + nameBracelet + ", brandBracelet=" + brandBracelet
				+ ", wipDate=" + wipDate + ", upDate=" + upDate + ", optionWaterProofYN=" + optionWaterProofYN
				+ ", optioncardiacFrequency=" + optioncardiacFrequency + ", optionGPS=" + optionGPS + "]";
	}

}
