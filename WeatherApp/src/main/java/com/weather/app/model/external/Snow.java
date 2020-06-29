package com.weather.app.model.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Snow {
	@JsonProperty("1h")
	private float lastOneHour;
	
	@JsonProperty("3h")
	private float lastThreeHours;

	public float getLastOneHour() {
		return lastOneHour;
	}

	public void setLastOneHour(float lastOneHour) {
		this.lastOneHour = lastOneHour;
	}

	public float getLastThreeHours() {
		return lastThreeHours;
	}

	public void setLastThreeHours(float lastThreeHours) {
		this.lastThreeHours = lastThreeHours;
	}

	@Override
	public String toString() {
		return "Snow [lastOneHour=" + lastOneHour + ", lastThreeHours=" + lastThreeHours + "]";
	}
	
	
}
