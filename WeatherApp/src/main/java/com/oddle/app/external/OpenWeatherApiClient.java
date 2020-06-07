package com.oddle.app.external;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oddle.app.model.external.WeatherCity;



@Service
public class OpenWeatherApiClient {
    private static final String WEATHER_MAP_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    @Value("${openweather.api}")
    private String appId;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private ObjectMapper mapper;
    
    private Logger logger = LoggerFactory.getLogger(OpenWeatherApiClient.class);

  public WeatherCity searchByCity(String city) throws JsonMappingException, IOException {
	  if ( StringUtils.isEmpty(city) ) return null;
	  
	  String url = String.format(WEATHER_MAP_URL, city, appId);
	 
	  logger.info("Getting data from OpenWeather for city: " + city);
	  ResponseEntity<String> response= restTemplate.getForEntity(url ,String.class);
	  logger.info("Get data from OpenWeather Success");
	  logger.info(response.getBody().toString());


	  WeatherCity weatherCity = mapper.readValue(response.getBody().toString(), WeatherCity.class);
	  logger.info("Mapping weather json to WeatherCity object success");
	  logger.info(weatherCity.toString());
	  
	  return weatherCity;

  }

}
