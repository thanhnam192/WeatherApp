package com.oddle.app.controller.api.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddle.app.dto.WeatherDto;
import com.oddle.app.mapper.WeatherLogToDtoMapper;
import com.oddle.app.model.WeatherLog;
import com.oddle.app.model.external.WeatherCity;
import com.oddle.app.services.WeatherLogService;

@Component
public class OpenWeatherApiLogic {
	@Autowired
	public WeatherLogService weatherLogService;
	
	@Autowired
	public ObjectMapper mapper;
	
	@Autowired
	private WeatherLogToDtoMapper weatherLogToDtoMapper;
	
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
	
	public List<WeatherDto> getAllWeatherCity(String city) throws JsonParseException, JsonMappingException, IOException{
		if( StringUtils.isEmpty(city) ) return new ArrayList<>();
		city = city.trim();
		List<WeatherLog> logs = (List<WeatherLog>) this.weatherLogService.listAll(city);
		List<WeatherDto> dtos = new ArrayList<>();
		for( WeatherLog log : logs ) {
			dtos.add(this.weatherLogToDtoMapper.toDto(log));
		}
		
		
		return dtos;
	}
	
}
