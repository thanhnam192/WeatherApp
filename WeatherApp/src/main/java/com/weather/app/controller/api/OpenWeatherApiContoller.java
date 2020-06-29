package com.weather.app.controller.api;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.weather.app.model.WeatherLog;
import com.weather.app.model.external.WeatherCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.weather.app.controller.api.logic.OpenWeatherApiLogic;
import com.weather.app.dto.WeatherDto;
import com.weather.app.external.OpenWeatherApiClient;
import com.weather.app.mapper.WeatherLogMapper;

@RestController
@RequestMapping("/api/weather")
public class OpenWeatherApiContoller {

	private OpenWeatherApiClient openWeatherApiClient;
	private OpenWeatherApiLogic openWeatherApiLogic;
	private WeatherLogMapper weatherLogMapper;

	@Autowired
	public OpenWeatherApiContoller(OpenWeatherApiClient openWeatherApiClient, OpenWeatherApiLogic openWeatherApiLogic,
			WeatherLogMapper weatherLogToDtoMapper) {
		this.openWeatherApiClient = openWeatherApiClient;
		this.openWeatherApiLogic = openWeatherApiLogic;
		this.weatherLogMapper = weatherLogToDtoMapper;
	}

	@GetMapping
	public ResponseEntity<?> getWeather(@RequestParam(name = "city") String city) {
		try {
			WeatherCity weather = openWeatherApiClient.searchByCity(city);
			if (weather == null) {
				return ResponseEntity.status(HttpStatus.OK).body("We have no information for " + city + " city");
			}
			WeatherLog log = this.openWeatherApiLogic.writeLog(weather);
			WeatherDto dto = this.weatherLogMapper.toDto(log);
			return new ResponseEntity(dto, HttpStatus.OK);

		} catch (JsonMappingException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while mapping data");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IO Error");
		}

	}

	@GetMapping("/showall")
	public ResponseEntity<?> getAllWeatherCity(@RequestParam(name = "city") String city) {
		try {
			List<WeatherDto> dtos = this.openWeatherApiLogic.getAllWeatherCity(city);
			return new ResponseEntity(dtos, HttpStatus.OK);

		} catch (JsonMappingException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while mapping data");
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IO Error");
		}
	}

	@DeleteMapping("/{id}")
	public void deleteWeatherLog(@PathVariable int id) {
		this.openWeatherApiLogic.deleteWeatherLog(id);
	}
	
	@GetMapping("/downloadCSV")
	public void downloadCSV(@RequestParam(name = "city") String city, HttpServletResponse response) throws IOException {
		String csvFileName = "logs.csv";
		 
        response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
        response.setHeader(headerKey, headerValue);
        
        this.openWeatherApiLogic.generateCsvFile(city, response);

	}
}
