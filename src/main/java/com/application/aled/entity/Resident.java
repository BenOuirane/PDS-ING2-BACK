
package com.application.aled.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Resident implements Serializable {
	@Id
	@GeneratedValue
	private Long idResident;
	private String firstName;
	private String lastName;
	private  int  age;

	@OneToOne(cascade = CascadeType.PERSIST, optional = true)
	@JoinColumn(unique = true)
	private Rooms room;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(unique = true)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idResidence")
	private Residence residence;

	@OneToOne
	private MedicalFolder medicalFolder;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(unique = true)
	private Subscription subscription;

	public Resident() {
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Long getIdResident() {
		return idResident;
	}

	public void setIdResident(Long idResident) {
		this.idResident = idResident;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public MedicalFolder getMedicalFolder() {
		return medicalFolder;
	}

	public void setMedicalFolder(MedicalFolder medicalFolder) {
		this.medicalFolder = medicalFolder;
	}

	@Override
	public String toString() {
		return "Resident{" +
				"idResident=" + idResident +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				", room=" + room +
				", user=" + user +
				", residence=" + residence +
				", medicalFolder=" + medicalFolder +
				'}';
	}

}
