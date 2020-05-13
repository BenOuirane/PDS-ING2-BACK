package com.application.aled.entity.model.link;

public class SumCurrentAreaBracelet {

	private Integer area_id;
	private Integer bracelet_id;
	private Integer total;
	
	public SumCurrentAreaBracelet(Integer area_id, Integer bracelet_id, Integer total) {
		super();
		this.area_id = area_id;
		this.bracelet_id = bracelet_id;
		this.total = total;
	}

	public Integer getArea_id() {
		return area_id;
	}

	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}

	public Integer getBracelet_id() {
		return bracelet_id;
	}

	public void setBracelet_id(Integer bracelet_id) {
		this.bracelet_id = bracelet_id;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	
}
