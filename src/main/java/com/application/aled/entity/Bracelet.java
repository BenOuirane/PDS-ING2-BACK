package com.application.aled.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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

	@Column(name = "last_sent")
	private LocalDateTime lastSentData;

	@Column(name = "ref_bracelet")
	private String refBracelet;

	@OneToMany(mappedBy = "bracelet", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CurrentArea> currentArea = new ArrayList<>();

	public List<CurrentArea> getCurrentArea() {
		return currentArea;
	}

	public void setCurrentArea(List<CurrentArea> currentArea) {
		this.currentArea = currentArea;
	}

	public Resident getResidents() {
		return residents;
	}

	public void setResidents(Resident residents) {
		this.residents = residents;
	}

	public Bracelet() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "Bracelet [id=" + id + ", idResident=" + ", lastSentData=" + lastSentData + ", refBracelet="
				+ refBracelet + "]";
	}

	public Bracelet(long id, long mcAddress, long idResident, LocalDateTime lastSentData, String refBracelet) {
		this.id = id;
		this.mcAddress = mcAddress;
		//this.idResident = idResident;
		this.lastSentData = lastSentData;
		this.refBracelet = refBracelet;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_resident", unique = true)
	@JsonIgnore
	private Resident residents;

}
