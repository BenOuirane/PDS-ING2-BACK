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
import org.hibernate.annotations.NaturalId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author ISMAIL EL HAMMOUD
 *
 */

//TODO Activate the cache once all dev is done
@Entity
@Table(name = "area")
//@NaturalIdCache
//@Cache(	usage = CacheConcurrencyStrategy.READ_ONLY)
public class Area {

	@Id
	@GeneratedValue
	private Long area_id;

	@NaturalId
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "area")
	private List<CurrentArea> areas = new ArrayList<>();

	@Column(name = "surface")
	private Double surface;

	@Column(name = "id_capteur")
	private String id_capteur;

	public Area() {
	}

	public Area(String name) {
		this.name = name;
	}

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "code_area", nullable = true)
	@JsonIgnore
	private AreaType areatype;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area_id == null) ? 0 : area_id.hashCode());
		result = prime * result + ((areas == null) ? 0 : areas.hashCode());
		result = prime * result + ((areatype == null) ? 0 : areatype.hashCode());
		result = prime * result + ((id_capteur == null) ? 0 : id_capteur.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		return result;
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
		if (area_id == null) {
			if (other.area_id != null)
				return false;
		} else if (!area_id.equals(other.area_id))
			return false;
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

	public Long getArea_id() {
		return area_id;
	}

	public void setArea_id(Long area_id) {
		this.area_id = area_id;
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

}
