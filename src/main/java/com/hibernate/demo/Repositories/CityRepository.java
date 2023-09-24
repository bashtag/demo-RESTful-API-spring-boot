package com.hibernate.demo.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hibernate.demo.Entities.City;
import java.util.List;


public interface CityRepository extends MongoRepository<City, ObjectId> {

	@Query("{'id': ?0}")
	List<City>	findByCustomId(Integer id);
}
