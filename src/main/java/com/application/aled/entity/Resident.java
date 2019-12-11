/**
 * 
 */
package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */



/* 
	This entity will be the table of Referential Bracelet
	Its attributes will be the following columns
	Every change in the backend side will impact the table 
	structure
*/

@XmlRootElement(name="Resident")
@Entity
@Table(name = "resident")
public class Resident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resident")
	private String id;

}
