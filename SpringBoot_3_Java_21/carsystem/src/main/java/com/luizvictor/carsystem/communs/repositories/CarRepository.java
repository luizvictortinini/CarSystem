package com.luizvictor.carsystem.communs.repositories;

import com.luizvictor.carsystem.communs.models.Car;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {

    @DeleteQuery("{'plate': {$in: ?0}}")
    void deleteByPlate(List<String> plates);

    @Query("{'plate': ?0}")
    Car findByPlate(String plate);

    @Query("{'brand.name': ?0}")
    List<Car> findByBrand(String brand);
}
