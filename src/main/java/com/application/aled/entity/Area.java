/**
 * 
 */
package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Entity
@Table(name = "area")
public class Area {
	
	@Id
	@Column(name = "name")
	private int area_name;
	
	@Column(name = "surface")
	private Double surface;
	
	@Column(name = "id_capteur")
	private String id_capteur;
	
	public Area() {}
	
	
}
