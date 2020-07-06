package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.assignment.model.Country;

@Component
public class CountryService {
	private List<Country> country = new ArrayList<Country>();
	
	public CountryService(@Value("${countries}") String[] countries,
						  @Value("${capitals}") String[] capitals,
						  @Value("${population}") Integer[] population) {
		for (int i = 0; i < countries.length; i++) {
			Country c = new Country();
			c.setName(countries[i]);
			c.setCapital(capitals[i]);
			c.setPopulation(population[i]);
			country.add(c);
		}
	}
	
	public Country getCountry(String name) {
		for (Country c : country) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	public List<Country> getAllCountry() {
		return country;
	}
}
