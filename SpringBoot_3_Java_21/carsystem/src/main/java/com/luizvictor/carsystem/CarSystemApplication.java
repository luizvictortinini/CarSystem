package com.luizvictor.carsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class CarSystemApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CarSystemApplication.class, args);
    }

}
