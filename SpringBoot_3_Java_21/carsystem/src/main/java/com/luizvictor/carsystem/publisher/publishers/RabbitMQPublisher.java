package com.luizvictor.carsystem.publisher.publishers;

import com.luizvictor.carsystem.communs.constants.RabbitMQConstants;
import com.luizvictor.carsystem.communs.models.Car;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisher {

    private final AmqpTemplate amqpTemplate;

    public RabbitMQPublisher(final AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessageCreate(final Car car) {
        amqpTemplate.convertAndSend(RabbitMQConstants.ROUTING_KEY_CREATE, car);
    }

    public void sendMessageUpdate(final Car car) {
        amqpTemplate.convertAndSend(RabbitMQConstants.ROUTING_KEY_UPDATE, car);
    }

    public void sendMessageDelete(final Car car) {
        amqpTemplate.convertAndSend(RabbitMQConstants.ROUTING_KEY_DELETE, car);
    }
}
