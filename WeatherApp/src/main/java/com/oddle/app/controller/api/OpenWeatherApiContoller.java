package com.oddle.app.controller.api;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oddle.app.external.OpenWeatherApiClient;

@RestController
@RequestMapping("/api/weather")
public class OpenWeatherApiContoller {

	public OpenWeatherApiClient openWeatherApiClient;
	
	public OpenWeatherApiContoller(OpenWeatherApiClient openWeatherApiClient) {
		this.openWeatherApiClient = openWeatherApiClient;
	}
	
	@GetMapping
	public ResponseEntity<?> getWeather(@RequestParam(name="city") String city)  {
		 try {
			return new  ResponseEntity(openWeatherApiClient.searchByCity(city), HttpStatus.OK);
			
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while mapping data");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error IO");
		}
		 
	}
}
