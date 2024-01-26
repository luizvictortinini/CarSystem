package com.luizvictor.carsystem.communs.repositories;

import com.luizvictor.carsystem.communs.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
}
