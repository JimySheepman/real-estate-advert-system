# Real Estate Advert System

## Introduction

Spring Boot framework of a restful application for an advertisement system, which receives the advertisement information and creates an advertisement record. I chose all the choices in the project, the most appropriate ones according to the case study.

### Non-Functional Requirements

* [X] Microservice Architecture
* [X] Clean Code
* [X] N-layer Architecture
* [X] SOLID
* [X] REST Convention
* [X] Exception handle
* [X] Data JPA/Hibernate
* [X] Exception handle
* [X] Postman Test
* [X] Containerization with Docker
* [X] Code Quality and Code Security Sonarlint


* **Features**
  * [ ] Documentation with Swagger -> Actually I did, but the library doesn't support 2.7.0+ so it doesn't work actively, but I made its impamentation.
  * [ ] Unit Test and Integration Test
  * [ ] Testing with Code Coverage > 80%

### Architecture

<p align="center">
<img src="assets/img/system-design.svg" alt="Architecture" title="Architecture"/>
</p>

### Tech Stack

* [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11)
  
* [Spring Boot](https://spring.io/projects/spring-boot)

* [Maven](https://maven.apache.org/)

* [Docker](https://www.docker.com/)
  
* [Postman](https://www.postman.com/)

* [PostgreSQL](https://www.postgresql.org/)

* [RabbitMQ](https://www.rabbitmq.com/)

## Project Information

### Quick Start

* Manuel

```Bash
# if local run in the microservice directory you want to run
$ mvn clean install 
# withouth test
$ mvn clean install -DskipTests
# if want to run manuel docker 
# build
$ mvn dockerfile:build
# run example
# If you want to start it manually, I suggest you look at the envirments of the relevant service in the docker-compose file.
$ docker run -it --rm -p 8081:8080 --name report report-service
```

* Automatic

```Bash
# if you want open detached mode(-d)
$ docker-compose up
```

### End-points

* `Advert-Service`
    > GET /api/v1/adverts/{id}

    ```Json
    // Response payload
    {
        "id" : 1,
        "title":"test",
        "information":"test",
        "description":"test",
        "password":"test",
        "location":"test",
        "createdAt":"new Date()",
        "updatedAt":"new Date()",
        "price":"12345",
        "views":0
    }
    ```

    > GET /api/v1/adverts

    ```Json
    // Response payload
    [
        {
            "id" : 1,
            "title":"test",
            "information":"test",
            "description":"test",
            "password":"test",
            "location":"test",
            "createdAt":"new Date()",
            "updatedAt":"new Date()",
            "price":"12345",
            "views":0
        },
        .
        .
    ]
    ```

    > POST /api/v1/adverts

    ```Json
    // Request payload
    {
        "title":"test",
        "information":"test",
        "description":"test",
        "password":"test",
        "location":"test",
        "price":"12345",
    }
    ```

    > GET /api/v1/adverts/manage/rejects

    ```Json
    // Response payload - hasAnyAuthority -> Admin
    [
        {
            "id" : 1,
            "title":"test",
            "information":"test",
            "description":"test",
            "password":"test",
            "location":"test",
            "createdAt":"new Date()",
            "updatedAt":"new Date()",
            "price":"12345",
            "views":0
        },
        .
        .
    ]
    ```

    > PATCH /api/v1/adverts/manage/{id}/approve

    ```Json
    // Response payload
    {
        "id" : 1,
        "title":"test",
        "information":"test",
        "description":"test",
        "password":"test",
        "location":"test",
        "createdAt":"new Date()",
        "updatedAt":"new Date()",
        "price":"12345",
        "views":0
    }
    ```

    > PATCH /api/v1/adverts/manage/{id}/disapprove

    ```Json
    // Response payload
    {
        "id" : 1,
        "title":"test",
        "information":"test",
        "description":"test",
        "password":"test",
        "location":"test",
        "createdAt":"new Date()",
        "updatedAt":"new Date()",
        "price":"12345",
        "views":0
    }
    ```

* `Auth-Service`
    > POST /login

    ```Json
    // Request payload - x-www-from-system
    {
        "username":"",
        "password":1234
    }
    ```

    ```Json
    // Response payload
    {
        "refresh_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1ODIwMTA5NH0.3gcuR1j1SwIdlx0mcDPHhWJZH3Lyn96H5zSa368p3R4",
        "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGVzIjpbIkFETUlOIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MS9sb2dpbiIsImV4cCI6MTY1ODIwMTA5NH0.3gcuR1j1SwIdlx0mcDPHhWJZH3Lyn96H5zSa368p3R4"
    }
    ```

    > POST /api/v1/register

    ```Json
    // Request payload
    {
        "name":"aaa",
        "surname":"test",
        "username":"test",
        "password":"test",
        "phoneNumber":"test",
        "email":"test@test.com"
    }
    ```

    ```Json
    // Response payload
    {
        "id": 1,
        "name":"aaa",
        "surname":"test",
        "username":"test",
        "password":"test",
        "phoneNumber":"test",
        "email":"test@test.com",
        "role": "ADMIN"
    }
    ```

    > GET /api/v1/users

    ```Json
    // Request payload - hasAnyAuthority -> Admin
    {
        "username":"",
        "password":1234
    }
    ```

    ```Json
    // Response payload
    [
        {
            "id": 1,
            "name":"aaa",
            "surname":"test",
            "username":"test",
            "password":"test",
            "phoneNumber":"test",
            "email":"test@test.com",
            "role": "ADMIN"
        },
        .
        .
    ]
    ```

    > GET /api/v1/token/{token}

    ```Json
    // Response payload
    {
        "username":"test",
        "role": "ADMIN"
    }
    ```

* `Report-Service`
    > GET /api/v1/report/{id}

    ```Json
    // Response payload - hasAnyAuthority -> Admin
    {
        "id":1,
        "username": "test",
        "createdAt":"new Date()",
        "views":1
    }
    ```

    > PUT /api/v1/report/{id}

    ```Json
    // Response payload - hasAnyAuthority -> Admin
    {
        "username": "test",
        "createdAt":"new Date()",
        "views":1
    }
    ```

    ```Json
    // Response payload
    {
        "id":1,
        "username": "test",
        "createdAt":"new Date()",
        "views":1
    }
    ```

### Project Structure

I gathered the microservice architecture under a single repo.

```Bash
.
├── advert-service
│   ├── advert-service.iml
│   ├── Dockerfile
│   ├── HELP.md
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── example
│       │   │           └── advertservice
│       │   │               ├── AdvertServiceApplication.java
│       │   │               ├── configuration
│       │   │               │   ├── RabbitMQConfiguration.java
│       │   │               │   └── SwaggerDocumentConfiguration.java
│       │   │               ├── controller
│       │   │               │   └── AdvertController.java
│       │   │               ├── dto
│       │   │               │   ├── AdvertCreateDTO.java
│       │   │               │   ├── AdvertSendProducerDTO.java
│       │   │               │   ├── AdvertUpdateDTO.java
│       │   │               │   ├── AdvertViewDTO.java
│       │   │               │   └── AdvertViewForAdminDTO.java
│       │   │               ├── exception
│       │   │               │   ├── ErrorHandler.java
│       │   │               │   └── NotFoundException.java
│       │   │               ├── mapper
│       │   │               │   └── AdvertModelMapper.java
│       │   │               ├── model
│       │   │               │   ├── Advert.java
│       │   │               │   └── UsernameAndRole.java
│       │   │               ├── producer
│       │   │               │   └── AdvertProducer.java
│       │   │               ├── repository
│       │   │               │   └── AdvertRepository.java
│       │   │               ├── security
│       │   │               │   ├── HttpConfigurer.java
│       │   │               │   ├── JwtAuthenticationFilter.java
│       │   │               │   ├── JwtAuthorizationFilter.java
│       │   │               │   └── SecurityConfig.java
│       │   │               └── service
│       │   │                   ├── AdvertServiceImpl.java
│       │   │                   └── AdvertService.java
│       │   └── resources
│       │       └── application.yml
│       └── test
│           └── java
│               └── com
│                   └── example
│                       └── advertservice
│                           └── AdvertServiceApplicationTests.java
├── assets
│   ├── design
│   │   └── emlakJet.excalidraw
│   ├── img
│   │   ├── system-design.png
│   │   └── system-design.svg
│   └── pdf
│       └── project.pdf
├── auth-service
│   ├── auth-service.iml
│   ├── Dockerfile
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── authservice
│   │   │   │               ├── AuthServiceApplication.java
│   │   │   │               ├── configuration
│   │   │   │               │   └── SwaggerDocumentConfiguration.java
│   │   │   │               ├── controllers
│   │   │   │               │   ├── SecurityController.java
│   │   │   │               │   └── UserController.java
│   │   │   │               ├── dto
│   │   │   │               │   ├── AddRoleRequestDTO.java
│   │   │   │               │   ├── CreateUserRequestModel.java
│   │   │   │               │   ├── ResponseModel.java
│   │   │   │               │   └── UserResponseModel.java
│   │   │   │               ├── error
│   │   │   │               │   ├── ErrorHandler.java
│   │   │   │               │   └── NotFoundException.java
│   │   │   │               ├── mapper
│   │   │   │               │   └── UserModelMapper.java
│   │   │   │               ├── models
│   │   │   │               │   ├── Role.java
│   │   │   │               │   ├── User.java
│   │   │   │               │   └── UsernameAndRole.java
│   │   │   │               ├── repositories
│   │   │   │               │   └── UserRepository.java
│   │   │   │               ├── security
│   │   │   │               │   ├── HttpConfigurer.java
│   │   │   │               │   ├── JwtAuthenticationFilter.java
│   │   │   │               │   ├── JwtAuthorizationFilter.java
│   │   │   │               │   ├── JwtUtil.java
│   │   │   │               │   └── SecurityConfig.java
│   │   │   │               └── services
│   │   │   │                   ├── UserServiceImpl.java
│   │   │   │                   └── UserService.java
│   │   │   └── resources
│   │   │       └── application.yml
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── authservice
│   │                       ├── AuthServiceApplicationTests.java
│   │                       └── services
│   │                           └── UserServiceImplTest.java
│   └── test.http
├── docker-compose.yml
├── LICENSE
├── README.md
└── report-service
    ├── Dockerfile
    ├── HELP.md
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── report-service.iml
    ├── request.http
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── example
        │   │           └── reportservice
        │   │               ├── configuration
        │   │               │   ├── RabbitMQConfiguration.java
        │   │               │   └── SwaggerDocumentConfiguration.java
        │   │               ├── consumer
        │   │               │   └── ReportConsumer.java
        │   │               ├── controller
        │   │               │   └── ReportController.java
        │   │               ├── dto
        │   │               │   ├── ConsumerReceiveMessageDTO.java
        │   │               │   ├── ReportCreateDTO.java
        │   │               │   ├── ReportUpdateDTO.java
        │   │               │   └── ReportViewDTO.java
        │   │               ├── exception
        │   │               │   ├── ErrorHandler.java
        │   │               │   └── NotFoundException.java
        │   │               ├── mapper
        │   │               │   └── ReportModelMapper.java
        │   │               ├── model
        │   │               │   ├── Report.java
        │   │               │   └── UsernameAndRole.java
        │   │               ├── ReportServiceApplication.java
        │   │               ├── repository
        │   │               │   └── ReportRepository.java
        │   │               ├── security
        │   │               │   ├── HttpConfigurer.java
        │   │               │   ├── JwtAuthenticationFilter.java
        │   │               │   ├── JwtAuthorizationFilter.java
        │   │               │   └── SecurityConfig.java
        │   │               └── service
        │   │                   ├── ReportServiceImpl.java
        │   │                   └── ReportService.java
        │   └── resources
        │       └── application.yml
        └── test
            └── java
                └── com
                    └── example
                        └── reportservice
                            └── ReportServiceApplicationTests.java

```

### Contributing

* **PR**'s are welcome !

* Found a Bug ? Create an **Issue**.

* Do you want to give **feedback**? Create an **Issue**.

### Like this project ?

Leave a star If you think this project is cool.

### Author

[JimySheepman](https://github.com/JimySheepman)

### Licence

[MIT](https://github.com/JimySheepman/real-estate-advert-system/blob/main/LICENSE)
