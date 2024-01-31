package com.luizvictor.carsystem.publisher.publishers;

import com.luizvictor.carsystem.communs.models.Car;
import com.luizvictor.carsystem.communs.properties.QueueProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RabbitMQPublisher {

    private final AmqpTemplate amqpTemplate;

    private final QueueProperties queueProperties;

    public RabbitMQPublisher(final AmqpTemplate amqpTemplate, final QueueProperties queueProperties) {
        this.amqpTemplate = amqpTemplate;
        this.queueProperties = queueProperties;
    }

    public void sendMessageCreate(final Car car) {
        amqpTemplate.convertAndSend(queueProperties.getCreate(), car);
    }

    public void sendMessageUpdate(final Car car) {
        amqpTemplate.convertAndSend(queueProperties.getUpdate(), car);
    }

    public void sendMessageDelete(final Set<String> plateIds) {
        amqpTemplate.convertAndSend(queueProperties.getDelete(), plateIds);
    }
}
