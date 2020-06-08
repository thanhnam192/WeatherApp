package com.oddle.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weather_log")
public class WeatherLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String country;
	
	private String city;
	
	@Column(name="weather_id")
	private long weatherId;
	
	private String content;
	
	private long timetamps;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(long weatherId) {
		this.weatherId = weatherId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getTimetamps() {
		return timetamps;
	}

	public void setTimetamps(long timetamps) {
		this.timetamps = timetamps;
	}

	@Override
	public String toString() {
		return "WeatherLog [id=" + id + ", country=" + country + ", city=" + city + ", weatherId=" + weatherId
				+ ", content=" + content + ", timetamps=" + timetamps + "]";
	}
	
}
