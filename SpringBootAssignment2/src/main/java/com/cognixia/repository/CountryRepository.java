package com.cognixia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cognixia.model.Country;

@RepositoryRestResource // set your interface as a repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

	@Query("select c from Country c where c.countryName=?1")
	Country getCountryByName(String name);
	
}

