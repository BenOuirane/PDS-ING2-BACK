/**
 * 
 */
package com.application.aled.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Entity
@Table(name = "area")
public class Area implements Serializable {
	
	@Id
	@Column(name = "name")
	private int area_name;
	
	@Column(name = "surface")
	private Double surface;
	
	@Column(name = "id_capteur")
	private String id_capteur;
	
	public Area() {}
	
	

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "code_area", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private AreaType areatype; 
	
	
	
}
