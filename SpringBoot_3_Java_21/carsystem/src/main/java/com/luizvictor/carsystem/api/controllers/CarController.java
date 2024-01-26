package com.luizvictor.carsystem.api.controllers;

import com.luizvictor.carsystem.api.services.CarService;
import com.luizvictor.carsystem.communs.vo.CarVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {


    private final CarService carService;

    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarVo>> getAllCars() {
        final List<CarVo> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }


    @GetMapping("/{plate}")
    public ResponseEntity<CarVo> getCarByPlate(@PathVariable final String plate) {
        final CarVo car = carService.getCarByPlate(plate);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<CarVo>> getCarsByBrand(final String brand) {
        final List<CarVo> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }


}
