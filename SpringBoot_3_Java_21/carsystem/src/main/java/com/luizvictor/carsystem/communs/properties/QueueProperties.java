package com.luizvictor.carsystem.communs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "queues")
public class QueueProperties {

    private String exchange;
    private String exchangeDlq;
    private String create;
    private String update;
    private String delete;
    private String dlqSuffix;
    private String routingKey;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(final String exchange) {
        this.exchange = exchange;
    }

    public String getExchangeDlq() {
        return exchangeDlq;
    }

    public void setExchangeDlq(final String exchangeDlq) {
        this.exchangeDlq = exchangeDlq;
    }

    public String getCreate() {
        return create;
    }

    public void setCreate(final String create) {
        this.create = create;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(final String update) {
        this.update = update;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(final String delete) {
        this.delete = delete;
    }

    public String getDlqSuffix() {
        return dlqSuffix;
    }

    public void setDlqSuffix(final String dlqSuffix) {
        this.dlqSuffix = dlqSuffix;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(final String routingKey) {
        this.routingKey = routingKey;
    }

    public String buildRoutingKeyDlq(final String queue) {
        return routingKey + queue + dlqSuffix;
    }

    public String buildRoutingKey(final String queue) {
        return routingKey + queue;
    }
}
