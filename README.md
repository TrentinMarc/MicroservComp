# MicroservComp

## Eureka client quick config

Replace

<span style="color:red">**[[PORT]]**</span>.

&

<span style="color:red">**[[SERVICE_NAME]]**</span>.

with your own config
###*(application.yml)*
```yaml
server:
  port: [[PORT]]

eureka:
  instance:
    leaseRenewalIntervalInSeconds: 5
    leaseExpirationDurationInSeconds: 2
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
    healthcheck:
      enabled: true
    lease:
      duration: 5

spring:
  application:
    name: [[SERVICE_NAME]]

management:
  security:
    enabled: false

logging:
  level:
    com.self.sprintboot.learning.employee: DEBUG
```

## Eureka Server quick config
###*(application.yml)*
```yaml
server:
  port: ${PORT:8761}

eureka:
  client:
    registryFetchIntervalSeconds: 5
    registerWithEureka: false
    serviceUrl:
      defaultZone: ${DISCOVERY_URL:http://localhost:8761}/eureka/
  instance:
    leaseRenewalIntervalInSeconds: 10

management:
  security:
    enabled: false
spring:
  boot:
    admin:
      context-path: /admin  #A different context path for admin server has been provided not conflicting with eureka
```
###*(bootstrap.yml)*
```yaml
spring:
  application:
    name: Eureka-Server
  cloud:
    config:
      uri: ${CONFIG_SERVER_URL:http://localhost:8888}
```
Make sure to match SERVER port in both config files