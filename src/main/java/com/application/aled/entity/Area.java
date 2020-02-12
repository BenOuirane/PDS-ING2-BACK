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
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

@Entity
@Table(name = "area")
//@NaturalIdCache
//@Cache(	usage = CacheConcurrencyStrategy.READ_WRITE)
public class Area implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NaturalId
	private String name;
	
	 @OneToMany(
		        mappedBy = "area",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
	private List<CurrentArea> areas = new ArrayList<>();
	
		 
	@Column(name = "surface")
	private Double surface;
	
	@Column(name = "id_capteur")
	private String id_capteur;
	
	public Area() {}
	
	public Area(String name) {
	        this.name = name;
	    }
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "code_area", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private AreaType areatype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CurrentArea> getAreas() {
		return areas;
	}

	public void setAreas(List<CurrentArea> areas) {
		this.areas = areas;
	}

	public Double getSurface() {
		return surface;
	}

	public void setSurface(Double surface) {
		this.surface = surface;
	}

	public String getId_capteur() {
		return id_capteur;
	}

	public void setId_capteur(String id_capteur) {
		this.id_capteur = id_capteur;
	}

	public AreaType getAreatype() {
		return areatype;
	}

	public void setAreatype(AreaType areatype) {
		this.areatype = areatype;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Area other = (Area) obj;
		if (areas == null) {
			if (other.areas != null)
				return false;
		} else if (!areas.equals(other.areas))
			return false;
		if (areatype == null) {
			if (other.areatype != null)
				return false;
		} else if (!areatype.equals(other.areatype))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_capteur == null) {
			if (other.id_capteur != null)
				return false;
		} else if (!id_capteur.equals(other.id_capteur))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		return true;
	}

	
	
	
	
}
