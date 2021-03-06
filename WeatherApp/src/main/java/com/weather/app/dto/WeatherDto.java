package com.weather.app.dto;

public class WeatherDto {
	private int id;
	private String city;
	private String country;
	private String date;
	private float temp;
	private float windSpeed;
	private int humidity;
	private int pressure;
	private String weatherIcon;
	private int cloud;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public String getWeatherIcon() {
		return weatherIcon;
	}
	public void setWeatherIcon(String weatherIcon) {
		this.weatherIcon = weatherIcon;
	}
	
	
	public int getCloud() {
		return cloud;
	}
	public void setCloud(int cloud) {
		this.cloud = cloud;
	}
	
	@Override
	public String toString() {
		return "WeatherDto [id=" + id + ", city=" + city + ", country=" + country + ", date=" + date + ", temp=" + temp
				+ ", windSpeed=" + windSpeed + ", humidity=" + humidity + ", pressure=" + pressure + ", weatherIcon="
				+ weatherIcon + ", cloud=" + cloud + "]";
	}

	
	
}
