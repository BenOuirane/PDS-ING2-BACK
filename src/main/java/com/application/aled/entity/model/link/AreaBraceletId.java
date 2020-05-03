package com.application.aled.entity.model.link;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class AreaBraceletId implements Serializable {
	
	@Column(name="bracelet_id")
	private Long braceletId;
	
	@Column(name="area_id")
	private String areaId;
	
	@Column(name = "crossDate")
    private LocalDateTime createdOn = LocalDateTime.now();
	
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public AreaBraceletId() {}
	
	public  AreaBraceletId(Long braceletId,String areaId ) {
		this.areaId=areaId;
		this.braceletId=braceletId;
	}
	public Long getBraceletId() {
		return braceletId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(braceletId, areaId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaBraceletId other = (AreaBraceletId) obj;
		if (areaId == null) {
			if (other.areaId != null)
				return false;
		} else if (!areaId.equals(other.areaId))
			return false;
		if (braceletId == null) {
			if (other.braceletId != null)
				return false;
		} else if (!braceletId.equals(other.braceletId))
			return false;
		return true;
	}

	public void setBraceletId(Long braceletId) {
		this.braceletId = braceletId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	
	
	//TODO check if PK and FK are well implemented..
	
}
