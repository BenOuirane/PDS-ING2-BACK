package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ReferentialResident")
public class ReferentialResident {

	@Column(name = "RefResident")
	private String refresident;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String LastName;

	@Column(name = "PhoneNumber")
	private String phonenumber;

	@Column(name = "RoomNumber")
	private String roomNumber;

	@Column(name = "ControlLevel")
	private String controlLevel;

	@Column(name = "DateArrived")
	private String dateArrived;

	public ReferentialResident(String refresident, String firstName, String lastName, String phonenumber,
			String roomNumber, String controlLevel, String dateArrived) {
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

	public String getDateArrived() {
		return dateArrived;
	}

	public void setDateArrived(String dateArrived) {
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
