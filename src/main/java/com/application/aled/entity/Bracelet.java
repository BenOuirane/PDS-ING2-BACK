package com.application.aled.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bracelet")
public class Bracelet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MCAddress")
	private String id;

	@Column(name = "IdResident")
	private String idResident;

	@Column(name = "LastSent")
	private Timestamp lastSentData;

	@Column(name = "RefBracelet")
	private String refBracelet;

}
