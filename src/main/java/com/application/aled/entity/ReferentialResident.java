package com.application.aled.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="referentialResident")
@Entity
@Table(name = "referential_resident")
public class ReferentialResident {

	@Column(name = "ref_resident")
	private String refresident;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String LastName;

	@Column(name = "phone_number")
	private String phonenumber;

	@Column(name = "room_number")
	private String roomNumber;

	@Column(name = "control_level")
	private String controlLevel;

	@Column(name = "date_arrived")
	private Timestamp dateArrived;

	public ReferentialResident(String refresident, String firstName, String lastName, String phonenumber,
			String roomNumber, String controlLevel, Timestamp dateArrived) {
		super();
		this.refresident = refresident;
		this.firstName = firstName;
		LastName = lastName;
		this.phonenumber = phonenumber;
		this.roomNumber = roomNumber;
		this.controlLevel = controlLevel;
		this.dateArrived = dateArrived;
	}

	public String getRefresident() {
		return refresident;
	}

	public void setRefresident(String refresident) {
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

	public Timestamp getDateArrived() {
		return dateArrived;
	}

	public void setDateArrived(Timestamp dateArrived) {
		this.dateArrived = dateArrived;
	}

	@Override
	public String toString() {
		return "ReferentialBracelet [refresident=" + refresident + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", phonenumber=" + phonenumber + ", roomNumber=" + roomNumber + ", controlLevel=" + controlLevel
				+ ", dateArrived=" + dateArrived + ", getRefresident()=" + getRefresident() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getPhonenumber()=" + getPhonenumber()
				+ ", getRoomNumber()=" + getRoomNumber() + ", getControlLevel()=" + getControlLevel()
				+ ", getDateArrived()=" + getDateArrived() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
