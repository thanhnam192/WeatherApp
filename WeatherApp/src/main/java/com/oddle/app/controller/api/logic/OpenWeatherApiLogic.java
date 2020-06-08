package com.oddle.app.controller.api.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddle.app.model.WeatherLog;
import com.oddle.app.model.external.WeatherCity;
import com.oddle.app.services.WeatherLogService;

@Component
public class OpenWeatherApiLogic {
	@Autowired
	public WeatherLogService weatherLogService;
	
	@Autowired
	public ObjectMapper mapper;
	
	public WeatherLog writeLog(WeatherCity weatherCity) throws JsonProcessingException {
		WeatherLog log = new WeatherLog();
		log.setCity(weatherCity.getName());
		log.setCountry(weatherCity.getSys().getCountry());
		log.setWeatherId(weatherCity.getId());
		log.setContent(mapper.writeValueAsString(weatherCity));
		log.setTimetamps(weatherCity.getDt());
		this.weatherLogService.saveOrUpdate(log);
		return log;
	}
	
}
