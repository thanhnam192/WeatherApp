package com.weather.app.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherCity {
	private Coordinate coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private Rain rain;
	private Snow snow;
	private int visibility;
	private Wind wind;
	private Clouds clouds;
	private long dt;
	private Sys sys;
	private int timezone;
	private long id;
	private String name;
	private int cod;
	public Coordinate getCoord() {
		return coord;
	}
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public int getTimezone() {
		return timezone;
	}
	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	
	public Rain getRain() {
		return rain;
	}
	public void setRain(Rain rain) {
		this.rain = rain;
	}
	public Snow getSnow() {
		return snow;
	}
	public void setSnow(Snow snow) {
		this.snow = snow;
	}
	@Override
	public String toString() {
		return "WeatherCity [coord=" + coord + ", weather=" + weather + ", base=" + base + ", main=" + main + ", rain="
				+ rain + ", snow=" + snow + ", visibility=" + visibility + ", wind=" + wind + ", clouds=" + clouds
				+ ", dt=" + dt + ", sys=" + sys + ", timezone=" + timezone + ", id=" + id + ", name=" + name + ", cod="
				+ cod + "]";
	}

}
