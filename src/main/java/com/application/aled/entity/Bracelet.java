package com.application.aled.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="bracelet")
@Entity
@Table(name = "bracelet")
public class Bracelet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mc_address")
	private String id;

	@Column(name = "id_resident")
	private String idResident;

	@Column(name = "last_sent")
	private Timestamp lastSentData;

	@Column(name = "ref_bracelet")
	private String refBracelet;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdResident() {
		return idResident;
	}

	public void setIdResident(String idResident) {
		this.idResident = idResident;
	}

	public Timestamp getLastSentData() {
		return lastSentData;
	}

	public void setLastSentData(Timestamp lastSentData) {
		this.lastSentData = lastSentData;
	}

	public String getRefBracelet() {
		return refBracelet;
	}

	public void setRefBracelet(String refBracelet) {
		this.refBracelet = refBracelet;
	}

	@Override
	public String toString() {
		return "Bracelet [id=" + id + ", idResident=" + idResident + ", lastSentData=" + lastSentData + ", refBracelet="
				+ refBracelet + "]";
	}

	public Bracelet(String id, String idResident, Timestamp lastSentData, String refBracelet) {
		super();
		this.id = id;
		this.idResident = idResident;
		this.lastSentData = lastSentData;
		this.refBracelet = refBracelet;
	}
	

}
