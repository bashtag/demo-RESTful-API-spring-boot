package com.hibernate.demo.Entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// These are for an sql db
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "city")

@Document(collection = "city")
public class City {
	// @Column(name = "id")
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private ObjectId	_id;

	private Integer id;
	
	// @Column(name = "name")
	private String name;
	
	// @Column(name = "countrycode")
	private String countrycode;
	
	// @Column(name = "district")
	private String district;
	
	// @Column(name = "population")
	private int population;

	// empty constructor for hibernate
	public City() {
	}
	
	public City(Integer id, String name, String countrycode, String district, int population) {
		this.id = id;
		this.name = name;
		this.countrycode = countrycode;
		this.district = district;
		this.population = population;
	}
	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
}
