package com.cognixia.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountrySender {
@Bean
public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String destination, CountryProducer producer) {
	return args -> {
	Country country = new Country();
		country.setCountryName("France");;
		country.setCapitalCity("Paris");
		country.setPopulation(66990000);
		country.setLandmark("Eiffel Tower");
		producer.sendTo(destination, country);
		};
	}
}
