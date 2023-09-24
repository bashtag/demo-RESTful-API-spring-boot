package com.hibernate.demo.Business;

import java.util.List;

import com.hibernate.demo.Entities.City;

public interface ICityService {
	List<City>	getAll();
	void	add(City city);
	void	update(City city);
	void	delete(City city);
	City	getById(Integer id);
}
