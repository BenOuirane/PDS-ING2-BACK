/**
 * 
 */
package com.application.aled.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import com.application.aled.entity.model.link.AreaBraceletId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Entity(name = "CurrentArea")
@Table(name = "current_area")
public class CurrentArea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AreaBraceletId id;


	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("braceletId")
	private Bracelet bracelet;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("code_area")
	private Area area;

	public CurrentArea(Area area, Bracelet bracelet) {
		this.area = area;
		this.bracelet = bracelet;
	}
	
	public CurrentArea() {
	}
	
	public AreaBraceletId getId() {
		return id;
	}

	public void setId(AreaBraceletId id) {
		this.id = id;
	}

	public Bracelet getBracelet() {
		return bracelet;
	}

	public void setBracelet(Bracelet bracelet) {
		this.bracelet = bracelet;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}	

	public LocalDateTime getCreatedOn() {
		return id.getCreatedOn();
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		}

	public Long getBraceletId() {
		return id.getBraceletId();
	}

}
