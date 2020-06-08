package com.oddle.app.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oddle.app.controller.api.logic.OpenWeatherApiLogic;
import com.oddle.app.external.OpenWeatherApiClient;
import com.oddle.app.model.external.WeatherCity;

@RestController
@RequestMapping("/api/weather")
public class OpenWeatherApiContoller {

	private OpenWeatherApiClient openWeatherApiClient;
	private OpenWeatherApiLogic openWeatherApiLogic;
	
	@Autowired
	public OpenWeatherApiContoller(OpenWeatherApiClient openWeatherApiClient, OpenWeatherApiLogic openWeatherApiLogic) {
		this.openWeatherApiClient = openWeatherApiClient;
		this.openWeatherApiLogic = openWeatherApiLogic;
	}
	
	@GetMapping
	public ResponseEntity<?> getWeather(@RequestParam(name="city") String city)  {
		 try {
			WeatherCity weather = openWeatherApiClient.searchByCity(city);
			this.openWeatherApiLogic.writeLog(weather);
			return new  ResponseEntity(weather, HttpStatus.OK);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while mapping data");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error IO");
		}
		 
	}
}
