package com.luizvictor.carsystem.publisher.controllers;

import com.luizvictor.carsystem.communs.vo.CarVo;
import com.luizvictor.carsystem.publisher.services.CarPublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("publisher/cars/batch")
public class CarControllerPublisher {

    private final CarPublisherService carPublisherService;

    public CarControllerPublisher(final CarPublisherService carPublisherService) {
        this.carPublisherService = carPublisherService;
    }

    @PostMapping("/")
    public void post(@RequestBody final Set<CarVo> cars) {
        carPublisherService.publishCars(cars);
    }

    @DeleteMapping("/{plates}")
    public void delete(@RequestParam final Set<String> plates) {
        carPublisherService.deleteCars(plates);
    }


}
