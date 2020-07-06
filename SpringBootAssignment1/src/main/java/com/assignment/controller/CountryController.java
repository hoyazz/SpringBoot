package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Country;
import com.assignment.service.CountryService;

@RestController
@RequestMapping("/")
public class CountryController {

	@Autowired
	private CountryService cs;
	
	@GetMapping("/")
	public String showCountries() {
		List<Country> countryList = cs.getAllCountry();
		String response = "<table border='1'><tr><td>Country</td><td>Capital</td></tr>";
		for (Country c : countryList) {
			response += "<tr><td><a href='/" + c.getName() + "'>" + c.getName() + "</a>" + "</td><td>" + c.getCapital() + "</td></tr>";
		}
		response += "</table>";
		return response;
	}
	
	@GetMapping("/{name}")
	public String showPopulationPathVar(@PathVariable String name) {
		Country country = cs.getCountry(name);
		String response = "";
		response += name + " has a population of " + country.getPopulation();
		response += "<br><br><a href=../>Go Back</a>";
		return response;
	}
	
	@GetMapping("/population")
	public String showPopulationGetReq(@RequestParam String name) {
		Country country = cs.getCountry(name);
		String response = "";
		if(country == null) {
			return "Country not found";
		}
		response += name + " has a population of " + country.getPopulation();
		response += "<br><br><a href=..>Go Back</a>";
		return response;
	}
	
	@PostMapping("/population")
	public String showPopulationPostReq(@RequestParam String name) {
		Country country = cs.getCountry(name);
		String response = "";
		if(country == null) {
			return "Country not found";
		}
		response += name + " has a population of " + country.getPopulation();
		response += "<br><br><a href=..>Go Back</a>";
		return response;
	}
}
