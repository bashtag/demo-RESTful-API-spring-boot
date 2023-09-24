package com.hibernate.demo.DataAccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.demo.Entities.City;
import com.hibernate.demo.Repositories.CityRepository;

// JPA - ORM
// Firstly it was appearing a data access technique, ORM. But it is used as a standart now.
// Both Hibernate and Spring implement JPA.
@Repository
public class HibernateCityDal implements ICityDal {

	private final CityRepository cityRepository;

	@Autowired
	public HibernateCityDal(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return (cityRepository.findAll());
	}

	@Override
	@Transactional
	public void add(City city) {
		if (cityRepository.findByCustomId(city.getid()).isEmpty())
			cityRepository.save(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		// if (cityRepository.exists(Example.of(city)))
		List<City>	citiesTemp = cityRepository.findByCustomId(city.getid());
		if (!citiesTemp.isEmpty()) {
			City	cityToUpdate = citiesTemp.get(0);
			cityToUpdate.setName(city.getName());
			cityToUpdate.setPopulation(city.getPopulation());
			cityToUpdate.setDistrict(city.getDistrict());
			cityToUpdate.setCountrycode(city.getCountrycode());

			cityRepository.save(cityToUpdate);
		}
	}

	@Override
	@Transactional
	public void delete(City city) {
		List<City>	citiesTemp = cityRepository.findByCustomId(city.getid());

		// if (cityRepository.exists(Example.of(city)))
		if (!citiesTemp.isEmpty())
			cityRepository.delete(citiesTemp.get(0));
	}

	@Override
	public City getById(Integer id) {
		List<City>	citiesToFind = cityRepository.findByCustomId(id);

		if (citiesToFind.isEmpty())
			return (null);
		return (citiesToFind.get(0));
	}

	// THESE CODES ARE FOR AN SQL DATABASE
	// // JPA (session in hibernate)
	// private EntityManager entityManager;

	// // now spring is implementing hibernate annotation. We got it using
	// autowired.
	// // It automaticly creates session factory etc.
	// @Autowired
	// public HibernateCityDal(EntityManager entityManager) {
	// this.entityManager = entityManager;
	// }

	// // unit of work is necessary now
	// // ASPECTED ORIENTED PROGRAMMING (AOP)
	// @Override
	// @Transactional
	// public List<City> getAll() {
	// Session session = entityManager.unwrap(Session.class);
	// List<City> cities = session.createNativeQuery("from city").getResultList();

	// return (cities);
	// }
}
