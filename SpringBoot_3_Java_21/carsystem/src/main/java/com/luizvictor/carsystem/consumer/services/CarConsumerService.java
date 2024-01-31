package com.luizvictor.carsystem.consumer.services;

import com.luizvictor.carsystem.communs.models.Car;
import com.luizvictor.carsystem.communs.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarConsumerService {
    private final CarRepository carRepository;

    public CarConsumerService(final CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void save(final Car car) {
        carRepository.save(car);
    }

    public void delete(final List<String> plates) {
        carRepository.deleteByPlate(plates);
    }
}
