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

/**
 * @author ISMAIL EL HAMMOUD
 *
 */
@Entity
@Table(name = "Resident")
public class Resident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "IdResident")
	private String id;

}
