package com.oddle.app.model.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {
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
		return "Rain [lastOneHour=" + lastOneHour + ", lastThreeHours=" + lastThreeHours + "]";
	}

	
}
