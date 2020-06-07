package com.oddle.app.model.external;

public class Coordinate {
	private String lon;
	private String lat;
	
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Coordinate [lon=" + lon + ", lat=" + lat + "]";
	}
	
	
	
	
}
