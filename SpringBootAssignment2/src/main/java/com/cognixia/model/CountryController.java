package com.cognixia.model;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
@Autowired
CountryService cs;

	/*
	 * @GetMapping("/Todo/{id}") Optional<Todo> getTodoByID(@PathVariable int id) {
	 * return ts.getTodoById(id); }
	 */
	@GetMapping("/Country/{name}")
		Country getCountryByName(@PathVariable String name) {
		return cs.getCountryByName(name);
	}
	
	@GetMapping("/Country")
		List<Country> getTodos(){
		return cs.getCountry();
	}

	@PostMapping("/Country")
	Country createTodo(@Valid @RequestBody Country country) {
	return cs.createCountry(country);
	}
}
