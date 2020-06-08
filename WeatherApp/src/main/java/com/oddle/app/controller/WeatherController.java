package com.oddle.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.oddle.app.services.WeatherLogService;

@Controller
@RequestMapping("/")
public class WeatherController {
	
	@Autowired
	public WeatherLogService weatherLogService;
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String list(ModelMap model) {
		model.addAttribute("message", "This is a boilerplate project");

		System.out.println(this.weatherLogService.listAll("Can Tho"));
		
		return "weather";
	}
}
