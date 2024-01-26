package com.luizvictor.carsystem.publisher.controllers;

import com.luizvictor.carsystem.communs.vo.CarVo;
import com.luizvictor.carsystem.publisher.services.CarPublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("publisher/cars/batch")
public class CarControllerPublisher {

    private final CarPublisherService carPublisherService;

    public CarControllerPublisher(final CarPublisherService carPublisherService) {
        this.carPublisherService = carPublisherService;
    }

    @PostMapping("/")
    public void post(@RequestBody final List<CarVo> cars) {
        carPublisherService.publishCars(cars);
    }


}
