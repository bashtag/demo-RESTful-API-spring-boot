package com.hibernate.demo.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.demo.DataAccess.ICityDal;
import com.hibernate.demo.Entities.City;

// Business layer
// Do it but these conditions
@Service
public class CityManager implements ICityService
{
	private ICityDal	cityDal;
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return (this.cityDal.getAll());
	}

	@Override
	@Transactional
	public void add(City city) {
		this.cityDal.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
	}

	@Override
	public City getById(Integer id) {
		return (this.cityDal.getById(id));
	}
	
}
