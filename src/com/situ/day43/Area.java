package com.situ.day43;

public class Area {
	private Integer id;
	private String area;
	private Integer city_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", area=" + area + ", city_id=" + city_id + "]";
	}

}
