package com.luizvictor.carsystem.consumer.listeners;

import com.luizvictor.carsystem.communs.models.Car;
import com.luizvictor.carsystem.communs.properties.QueueProperties;
import com.luizvictor.carsystem.consumer.services.CarConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitMQListener {

    private final QueueProperties queueProperties;

    private final CarConsumerService carConsumerService;

    public RabbitMQListener(final QueueProperties queueProperties, final CarConsumerService carConsumerService) {
        this.queueProperties = queueProperties;
        this.carConsumerService = carConsumerService;
    }

    @RabbitListener(queues = "#{queueProperties.getCreate()}")
    public void create(final Car message) throws InterruptedException {
        carConsumerService.save(message);
    }

    @RabbitListener(queues = "#{queueProperties.getDelete()}")
    public void delete(final List<String> message) throws InterruptedException {
        carConsumerService.delete(message);
    }

}
