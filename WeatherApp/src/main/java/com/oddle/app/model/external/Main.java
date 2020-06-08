package com.oddle.app.model.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
	private int temp;
	
	@JsonProperty("feels_like")
	private int feelsLike;
	
	@JsonProperty("temp_min")
	private int tempMin;
	
	@JsonProperty("temp_max")
	private int tempMax;
	
	private int pressure;
	private int humidity;
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public int getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(int feelsLike) {
		this.feelsLike = feelsLike;
	}
	public int getTempMin() {
		return tempMin;
	}
	public void setTempMin(int tempMin) {
		this.tempMin = tempMin;
	}
	public int getTempMax() {
		return tempMax;
	}
	public void setTempMax(int tempMax) {
		this.tempMax = tempMax;
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	@Override
	public String toString() {
		return "Main [temp=" + temp + ", feelsLike=" + feelsLike + ", tempMin=" + tempMin + ", tempMax=" + tempMax
				+ ", pressure=" + pressure + ", humidity=" + humidity + "]";
	}
	
	
}
