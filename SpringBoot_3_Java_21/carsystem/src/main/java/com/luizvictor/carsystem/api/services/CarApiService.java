package com.luizvictor.carsystem.api.services;

import com.luizvictor.carsystem.communs.mappers.CarMapper;
import com.luizvictor.carsystem.communs.models.Car;
import com.luizvictor.carsystem.communs.repositories.CarRepository;
import com.luizvictor.carsystem.communs.vo.CarVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarApiService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarApiService(final CarRepository carRepository, final CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<CarVo> getAllCars() {
        final List<Car> cars = carRepository.findAll();
        return carMapper.carToCarVo(cars);
    }

    public CarVo getCarByPlate(final String plate) {
        return carMapper.carToCarVo(carRepository.findByPlate(plate));
    }

    public List<CarVo> getCarByBrand(final String brand) {
        return carMapper.carToCarVo(carRepository.findByBrand(brand));
    }

}