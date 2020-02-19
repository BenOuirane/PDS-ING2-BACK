/**
 * 
 */
package com.application.aled.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

import com.application.aled.entity.model.link.AreaBraceletId;
/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Entity(name="CurrentArea")
@Table(name = "current_area")
public class CurrentArea  implements Serializable {
	
	
	@EmbeddedId
	private AreaBraceletId id; 

	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("braceletId")
    private Bracelet bracelet;
	
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

	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("areaId")
    private Area area;
	
	
	
	public CurrentArea() {}

	public CurrentArea (Area area, Bracelet bracelet) {
		this.area=area;
		this.bracelet=bracelet;
		//this.id = new AreaBraceletId(Are
	}
	
	
	 //private LocalDateTime 	crossDate;

	
	
	
	public LocalDateTime getCreatedOn() {
		return id.getCreatedOn();
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		//this.createdOn = createdOn;
	}
	
	public Long getBraceletId() {
		return id.getBraceletId();
	}

	
}
