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
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("areaId")
    private Area  area;
	
	@Column(name = "crossDate")
    private LocalDateTime createdOn = LocalDateTime.now();
	
	public CurrentArea() {}
	public CurrentArea (Area area, Bracelet bracelet) {
		this.area=area;
		this.bracelet=bracelet;
		//this.id = new AreaBraceletId(Are
	}
	
	@Id
    @ManyToOne
    @JoinColumn
    private Bracelet bracelets;
	
	 @Id
	 @ManyToOne
	 @JoinColumn
	 private Area areas;
	
	 private LocalDateTime 	crossDate;

	
	
	public CurrentArea(Bracelet bracelets, LocalDateTime crossDate, Area areas) {
		super();
		this.bracelets = bracelets;
		this.crossDate = crossDate;
		this.areas= areas;
		
	}
	
	
}
