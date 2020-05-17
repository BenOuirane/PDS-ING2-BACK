package com.application.aled.entity.model.link;

import org.hibernate.annotations.Entity;


public class SumCurrentAreaBracelet {

	private Long areaId;
	public Long braceletId;
	private Long total;
	
	public SumCurrentAreaBracelet(Long areaId, Long braceletId, Long total) {
		this.areaId = areaId;
		this.braceletId = braceletId;
		this.total = total;
	}
	
	/*public SumCurrentAreaBracelet(Integer areaId, Long braceletId) {
		this.areaId = areaId;
		this.braceletId = braceletId;
	}*/
	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getBraceletId() {
		return braceletId;
	}

	public void setBraceletId(Long braceletId) {
		this.braceletId = braceletId;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	
}
