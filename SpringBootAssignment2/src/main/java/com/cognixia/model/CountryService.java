package com.cognixia.model;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.repository.CountryRepository;

@Service
public class CountryService {
@Autowired
CountryRepository cs;

	public Country createCountry(Country country) {
		return cs.save(country);
	}
	public List<Country> getCountry() {
		return cs.findAll();
	}

	public Country getCountryByName(String name) {
		return cs.getCountryByName(name);
	}
}