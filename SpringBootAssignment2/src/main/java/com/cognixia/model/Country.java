package com.cognixia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // this whole bean will be converted to a table with this annotation
public class Country {
	
	@GeneratedValue // is generated
	@Id // denotes primary key
	private int countryId;
	
	@NotNull
	private String countryName;
	private String capitalCity;
	private int population;
	
	@NotNull
	@NotBlank
	@Size(min = 5, max = 64, message = "Landmark name length must be greater than 5")
	private String landmark;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public String getCapitalCity() {
		return capitalCity;
	}

	public void setCapitalCity(String capitalCity) {
		this.capitalCity = capitalCity;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", capitalCity=" + capitalCity
				+ ", population=" + population + ", landmark=" + landmark + "]";
	}

}
