package com.hibernate.demo.DataAccess;

import java.util.List;

import com.hibernate.demo.Entities.City;

public interface ICityDal {
	List<City>	getAll();
	void	add(City city);
	void	update(City city);
	void	delete(City city);
	City	getById(Integer id);
}
