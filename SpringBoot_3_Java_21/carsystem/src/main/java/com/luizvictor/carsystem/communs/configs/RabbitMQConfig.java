package com.luizvictor.carsystem.communs.configs;

import com.luizvictor.carsystem.communs.properties.QueueProperties;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableRabbit
public class RabbitMQConfig {


    private final QueueProperties queueProperties;
    private final RabbitProperties properties;

    private TopicExchange topicExchange;

    private TopicExchange topicExchangeDlq;

    public RabbitMQConfig(final QueueProperties queueProperties, final RabbitProperties properties) {
        this.queueProperties = queueProperties;
        this.properties = properties;
    }


    @Bean
    public TopicExchange emptiesExchange() {
        topicExchange = new TopicExchange(queueProperties.getExchange(), true, false);
        return topicExchange;
    }

    @Bean
    public TopicExchange emptiesExchangeDlq() {
        topicExchangeDlq = new TopicExchange(queueProperties.getExchangeDlq(), true, false);
        return topicExchangeDlq;
    }

    @Bean
    public List<String> declaredQueues(final QueueProperties properties) {
        final List<String> declaredQueues = new ArrayList<>();
        declaredQueues.add(queueProperties.getCreate());
        declaredQueues.add(queueProperties.getUpdate());
        declaredQueues.add(queueProperties.getDelete());
        return declaredQueues;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}