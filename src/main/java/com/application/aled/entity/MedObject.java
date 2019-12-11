package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



/* 
	This entity will be the table of Medical Object
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/

@XmlRootElement(name="medicalObject")
@Entity
@Table(name = "medical_object")
public class MedObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medObject")
	private int id;

}
