First: Config Server
Second: Discovery Server
Third: API Gateway
Fourth: 4 microservices: auth, drug, order, inventory


Common pattern for all microservices

Auth-service
Drug-service
Order-service
inventory-service

Each service
Has its own Spring Boot project
Uses Config Server -> bootstrap.yml
Registers to Discovery Server -> eureka.client

Dependencies for each microservice
  Dependencies
Spring Web
Spring Data JPA
MySQL Driver
Spring Kafka (for order/inventory)
Eureka Client
Lombok
