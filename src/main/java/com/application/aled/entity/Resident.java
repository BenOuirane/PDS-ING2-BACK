
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
	private  int  idRoom;
	private  int  idMedicalFolder;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idResidence")
	private Residence residence;
	//@OneToMany(mappedBy = "resident", fetch = FetchType.LAZY)
	//private Collection<Object> objects;
	@OneToOne
	private MedicalFolder medicalFolder;

	public Resident() {
		super();
	}

	public Resident( String firstName, String lastName, int age, int idRoom, int idMedicalFolder) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

		this.idRoom = idRoom;
		this.idMedicalFolder = idMedicalFolder;
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

	public void setFirsName(String firstName) {
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

	public int getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public int getIdMedicalFolder() {
		return idMedicalFolder;
	}

	public void setIdMedicalFolder(int idMedicalFolder) {
		this.idMedicalFolder = idMedicalFolder;
	}

	/*public Collection<Object> getObjects() {
		return objects;
	}

	public void setObjects(Collection<Object> objects) {
		this.objects = objects;
	}*/

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
				", firsName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				//", getIdResidence=" + IdResidence +
				", idRoom=" + idRoom +
				", idMedicalFolder=" + idMedicalFolder +
				//", objects=" + objects +
				", medicalFolder=" + medicalFolder +
				'}';
	}
}
