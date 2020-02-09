package com.application.aled.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "bracelet")
public class Bracelet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "mc_address", nullable = false, unique = true)
	private long mcAddress;

	public long getMcAddress() {
		return mcAddress;
	}

	public void setMcAddress(long mcAddress) {
		this.mcAddress = mcAddress;
	}
	@Column(name = "id_resident")
	private String idResident;

	@Column(name = "last_sent")
	private LocalDateTime lastSentData;

	@Column(name = "ref_bracelet")
	private String refBracelet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdResident() {
		return idResident;
	}

	public void setIdResident(String idResident) {
		this.idResident = idResident;
	}

	public LocalDateTime getLastSentData() {
		return lastSentData;
	}

	public void setLastSentData(LocalDateTime lastSentData) {
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

	
	public Bracelet(long id, long mcAddress, String idResident, LocalDateTime lastSentData, String refBracelet) {
		this.id = id;
		this.mcAddress = mcAddress;
		this.idResident = idResident;
		this.lastSentData = lastSentData;
		this.refBracelet = refBracelet;
	}

	public Bracelet() { }
	
	
	//TODO add PK and FK 
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name= "id_resident", unique = true )
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Resident residents;
	
}
