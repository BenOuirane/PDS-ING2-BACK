package com.application.aled.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


//this entity will be removed as discussed with another team member working
// on the same env
/* 
	This entity will be the table of Referential Bracelet
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/	



@XmlRootElement(name="referentialResident")
@Entity
//@Table(name = "referential_resident")
public class ReferentialResident {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ref_resident", nullable = false, unique = true)
	private int refresident;


	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String LastName;

	@Column(name = "control_level")
	private String controlLevel;

	@Column(name = "date_arrived")
	private LocalDateTime dateArrived;
	
	@Column(name = "phone_number")
	private String phonenumber;

	@Column(name = "room_number")
	private String roomNumber;


	public ReferentialResident(int refresident, String firstName, String lastName, String phonenumber,
			String roomNumber, String controlLevel, LocalDateTime dateArrived) {
		this.refresident = refresident;
		this.firstName = firstName;
		this.LastName = lastName;
		this.phonenumber = phonenumber;
		this.roomNumber = roomNumber;
		this.controlLevel = controlLevel;
		this.dateArrived = dateArrived;
	}

	public ReferentialResident() {}
	public int getRefresident() {
		return refresident;
	}

	public void setRefresident(int refresident) {
		this.refresident = refresident;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getControlLevel() {
		return controlLevel;
	}

	public void setControlLevel(String controlLevel) {
		this.controlLevel = controlLevel;
	}

	public LocalDateTime getDateArrived() {
		return dateArrived;
	}

	public void setDateArrived(LocalDateTime dateArrived) {
		this.dateArrived = dateArrived;
	}


	


}
