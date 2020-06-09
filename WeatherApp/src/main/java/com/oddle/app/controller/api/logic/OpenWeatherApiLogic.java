package com.oddle.app.controller.api.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddle.app.dto.WeatherDto;
import com.oddle.app.mapper.WeatherLogMapper;
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
	private WeatherLogMapper weatherLogMapper;
	
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
			dtos.add(this.weatherLogMapper.toDto(log));
		}
		
		
		return dtos;
	}
	
	public void deleteWeatherLog(int id) {
		this.weatherLogService.delete(id);;
	}
	
	public void generateCsvFile(String city, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		List<WeatherDto> dtos =  getAllWeatherCity(city);
		
	     // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "id", "city", "country", "date", "temp", "windSpeed", "humidity","pressure","weatherIcon" };
 
        csvWriter.writeHeader(header);
 
        for (WeatherDto dto : dtos) {
            csvWriter.write(dto, header);
        }
 
        csvWriter.close();
	}
	
}
