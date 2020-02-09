/**
 * 
 */
package com.application.aled.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
/**
 * @author ISMAIL EL HAMMOUD
 *
 */




@Entity
@Table(name = "current_location")
public class CurrentLocation  implements Serializable {


	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "id_bracelet", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Bracelet bracelets;*/
	
	
	@Id
    @ManyToOne
    @JoinColumn
    private Bracelet bracelets;
	
	 @Id
	 @ManyToOne
	 @JoinColumn
	 private Area areas;
	
	 private LocalDateTime 	crossDate;

	/*@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "code_area", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Area areas;*/
	
	public CurrentLocation(Bracelet bracelets, LocalDateTime crossDate, Area areas) {
		super();
		this.bracelets = bracelets;
		this.crossDate = crossDate;
		this.areas= areas;
		
	}
	public CurrentLocation(){}
	
}
