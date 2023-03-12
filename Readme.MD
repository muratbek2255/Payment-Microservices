This payment project in microservices:

1.First module API_GATEWAY:
Spring Boot is an open-source Java-based framework used to create stand-alone, production-grade web applications and services. ...
An API gateway is a component that sits between your backend services and your API clients.

2.Second module is discovery-server:
Eureka Server is an application that holds the information about all client-service applications. Every Micro service will register into the Eureka server and Eureka server knows all the client applications running on each port and IP address. Eureka Server is also known as Discovery Server.


3.Third module payment-service:
# Payment

```bash
Add configuration in src/main/resources/application.properties
    #YOUR DATABASE URL jdbc:postgresql://port_db/db
spring.datasource.url=your_db
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

server.servlet.context-path=/api/v1
#Your server port
server.port=

```

```bash
    Endpoints:
      http://localhost:8000/api/v1/payment:
        Post-method: in is Endpoint favour module send data to payment-service 
    
      http://localhost:8000/api/v1/payment:
        Post-method: Payment is checked
    
      http://localhost:8000/api/v1/payment/check/{id}:
        Post-method: Payment is checked
  
      http://localhost:8000/api/v1/payment
          Put-method:Result: Payment Created!
              
              
      http://localhost:8000/api/v1/payment/setStatus/{id}
          Put-method: Result: Your status in payment: STATUS_SUCCESS
              
              
      http://localhost:8000/api/v1/payment/rollbackStatus/{id}
          Put-method: Result: Rollback payment
              
      http://localhost:8000/api/v1/payment/status
                 Param: status = ?
                 
           Get-method: Result: Payment with status: [list]
```

4.Fourth module is Favour:
# Favour

```bash
  spring application-properties:
    spring.cloud.config.import-check.enabled=false

    spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/wallet_kg
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.datasource.username=postgres
    spring.datasource.password=shutyourmouthrat
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    
    server.port=8000
    server.servlet.context-path=/api/v1/
    
    eureka.client.service-url.default-zone=http://localhost:8761/eureka
    
    spring.zipkin.base-url=http://localhost:9411
    spring.sleuth.sampler.probability=1.0
    
    spring.cloud.compatibility-verifier.enabled=false
    
    spring.application.name=favour
Endpoints:
    CRUD favour
    
    And update and delete parent category:
    http://localhost:8000/api/v1/favour-categories/update-favour-category-child/{id}
      Put: Add parent to child category
      
    http://localhost:8000/api/v1/favour-categories/delete-favour-category-child/{id}
      Delete parent to child category
    
```