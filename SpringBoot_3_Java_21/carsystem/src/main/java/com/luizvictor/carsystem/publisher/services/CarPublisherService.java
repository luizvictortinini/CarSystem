package com.luizvictor.carsystem.publisher.services;

import com.luizvictor.carsystem.communs.mappers.CarMapper;
import com.luizvictor.carsystem.communs.models.Car;
import com.luizvictor.carsystem.communs.vo.CarVo;
import com.luizvictor.carsystem.publisher.publishers.RabbitMQPublisher;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CarPublisherService {

    private final RabbitMQPublisher rabbitMQPublisher;
    private final CarMapper carMapper;

    public CarPublisherService(final RabbitMQPublisher rabbitMQPublisher, final CarMapper carMapper) {
        this.rabbitMQPublisher = rabbitMQPublisher;
        this.carMapper = carMapper;
    }

    public void publishCars(final Set<CarVo> cars) {
        cars.stream().parallel().forEach(i -> {
            final Car car = carMapper.carVoToCar(i);
            rabbitMQPublisher.sendMessageCreate(car);
        });
    }

    public void deleteCars(final Set<String> plates) {
        rabbitMQPublisher.sendMessageDelete(plates);
    }
}
