package com.oddle.app.mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddle.app.dto.WeatherDto;
import com.oddle.app.model.WeatherLog;
import com.oddle.app.model.external.WeatherCity;

@Component
public class WeatherLogToDtoMapper {
	
	@Autowired
	public ObjectMapper mapper;
	
	public WeatherDto map(WeatherLog log) throws JsonParseException, JsonMappingException, IOException {
		 WeatherCity weatherCity = mapper.readValue(log.getContent(), WeatherCity.class);
		 WeatherDto dto = new WeatherDto();
		 dto.setId(log.getId());
		 dto.setCity(log.getCity());
		 dto.setCountry(log.getCountry());
		 dto.setDate(convertTimetampsToDateString(log.getTimetamps()));
		 dto.setTemp(weatherCity.getMain().getTemp());
		 dto.setWindSpeed(weatherCity.getWind().getSpeed());
		 dto.setHumidity(weatherCity.getMain().getHumidity());
		 dto.setPressure(weatherCity.getMain().getPressure());
		 
		 return dto;
	}
	
	private String convertTimetampsToDateString(long timetamps) {
		Timestamp stamp = new Timestamp( timetamps * 1000);
		Date date = new Date(stamp.getTime());
		String pattern = "dd-MM-yyyy hh:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}
	

}
