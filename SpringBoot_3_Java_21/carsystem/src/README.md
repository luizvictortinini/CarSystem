# Car System

A modern Spring Boot 3 application built with Java 21 for managing car information through a distributed system architecture using MongoDB and RabbitMQ.

## 🚀 Features

- RESTful API for car management
- Message-based architecture using RabbitMQ
- MongoDB database integration
- Publisher/Consumer pattern implementation
- Batch operations support
- Dead Letter Queue (DLQ) handling

## 🛠 Tech Stack

- Java 21
- Spring Boot 3
- MongoDB
- RabbitMQ
- MapStruct
- Spring AMQP

## 📋 Prerequisites

- Java 21
- MongoDB
- RabbitMQ
- Maven

## ⚙️ Configuration

The application uses YAML configuration. Main configurations can be found in `application.yaml`:

```yaml
server:
  port: 8080

spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/CarSystem
  rabbitmq:
    host: localhost
    port: 5672
    username: car
    password: car
```

## 🏗 Architecture

The project is structured into several main components:

### API Layer
- REST endpoints for car management
- CRUD operations through HTTP endpoints

### Publisher
- Handles message publishing to RabbitMQ
- Supports batch operations for car creation and deletion

### Consumer
- Processes messages from RabbitMQ queues
- Implements business logic for car operations

### Common
- Shared models, repositories, and utilities
- Data transfer objects (VOs) and mappers

## 🔄 Message Queues

The system uses the following RabbitMQ queues:
- `create`: For car creation operations
- `update`: For car update operations
- `delete`: For car deletion operations
- Dead Letter Queues (DLQ) for each operation

## 🚗 API Endpoints

### Car Controller (API)
- `GET /api/cars`: Retrieve all cars
- `GET /api/cars/{plate}`: Get car by plate number
- `GET /api/cars/brand/{brand}`: Get cars by brand

### Publisher Controller
- `POST /publisher/cars/batch/`: Batch create/update cars
- `DELETE /publisher/cars/batch/{plates}`: Batch delete cars by plates

## 🐳 Docker Environment

You can run MongoDB and RabbitMQ using Docker Compose. The configuration is available in `env/docker-compose.yml`:

```yaml
version: '3'
services:
  mongodb:
    image: mongo:latest
    container_name: mongodb
    ports:
      - "27017:27017"

  rabbitmq:
    image: rabbitmq:3-management
    container_name: rabbitmq
    environment:
      RABBITMQ_DEFAULT_USER: car
      RABBITMQ_DEFAULT_PASS: car
    ports:
      - "5672:5672"
      - "15672:15672"
```

To start the containers:
```bash
cd env
docker-compose up -d
```

This will start:
- MongoDB on port 27017
- RabbitMQ on port 5672 (AMQP) and 15672 (Management UI)

## 🏃‍♂️ Running the Application

1. Start MongoDB:
```bash
mongod
```

2. Start RabbitMQ:
```bash
rabbitmq-server
```

3. Run the application:
```bash
./mvnw spring-boot:run
```

## 📝 Data Models

### Car
```java
- id: String
- plate: String
- chassis: String
- model: Model
- brand: Brand
```

### Brand
```java
- name: String
- country: String
```

### Model
```java
- name: String
- year: int
```

## 🤝 Contributing

Feel free to contribute to this project by submitting issues or pull requests.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details. 