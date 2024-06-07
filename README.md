## Math Learning Platform (MLP) - README

### Overview

The **Math Learning Platform (MLP)** is a microservices-based application designed to help users learn and solve mathematical problems. This project aims to provide a hands-on experience with various technologies such as Java 21, Spring Boot, Docker, Spring Security, asynchronous communication, REST APIs, CI/CD with GitHub, and more.

### Table of Contents

1. [Project Description](#project-description)
2. [Technologies Used](#technologies-used)
3. [Microservices Overview](#microservices-overview)
4. [Setup and Installation](#setup-and-installation)
5. [Development Steps](#development-steps)
6. [Security Considerations](#security-considerations)
7. [Future Enhancements](#future-enhancements)
9. [License](#license)

### Project Description

The Math Learning Platform (MLP) provides the following functionalities:

- User registration, authentication, and profile management.
- Math problem creation, listing, and retrieval.
- Asynchronous evaluation of user-submitted solutions.
- Leaderboard tracking and displaying user rankings.
- Notification system for user activities.

This project is built using a microservices architecture, with each service handling a distinct part of the overall functionality. The services communicate asynchronously using RabbitMQ and are managed through a centralized API Gateway.

### Technologies Used

- **Java 21**
- **Spring Boot**
- **Spring Security**
- **Spring Cloud (Config, Eureka, Gateway)**
- **Docker & Docker Compose**
- **RabbitMQ**
- **GitHub Actions**
- **H2 Database**
- **MySQL**
- **Maven**

### Microservices Overview

1. **User Management Service**: Manages user accounts and authentication.
2. **Math Problem Service**: Manages mathematical problems.
3. **Solution Evaluation Service**: Evaluates user solutions asynchronously.
4. **Leaderboard Service**: Tracks and displays user rankings.
5. **Notification Service**: Sends notifications based on user activities.
6. **API Gateway**: Routes requests to the appropriate services.
7. **Config Server**: Provides centralized configuration management.
8. **Eureka Server**: Manages service registration and discovery.

### Setup and Installation

#### Prerequisites

- **Java 21**
- **Maven**
- **Docker & Docker Compose**
- **Git** for version control

#### Installation Steps

1. **Clone the Repository**
   - Clone the project repository from GitHub to your local machine.
   - ```bash
     git clone https://github.com/your-username/math-platform.git
     cd math-platform
     ```
   - [ ] Repository cloned and navigated to the project directory.

2. **Build the Project**
   - Use Maven to clean and build the project to ensure all dependencies are correctly installed.
   - ```bash
     mvn clean install
     ```
   - [ ] Project built successfully with Maven.

3. **Setup Docker and RabbitMQ**
   - Ensure Docker is installed and running on your system.
   - RabbitMQ will be set up through Docker Compose along with other services.

4. **Prepare Docker Compose Configuration**
   - Create a `docker-compose.yml` file in the root directory of your project with the following configuration:
     ```yaml
     version: '3.8'

     services:
       eureka-server:
         image: openjdk:21-jre-slim
         container_name: eureka-server
         ports:
           - "8761:8761"
         volumes:
           - ./eureka-server:/app
         working_dir: /app
         command: ["java", "-jar", "target/eureka-server-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network

       config-server:
         image: openjdk:21-jre-slim
         container_name: config-server
         ports:
           - "8888:8888"
         volumes:
           - ./config-server:/app
         working_dir: /app
         command: ["java", "-jar", "target/config-server-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network

       api-gateway:
         image: openjdk:21-jre-slim
         container_name: api-gateway
         ports:
           - "8080:8080"
         volumes:
           - ./api-gateway:/app
         working_dir: /app
         command: ["java", "-jar", "target/api-gateway-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network

       user-management-service:
         image: openjdk:21-jre-slim
         container_name: user-management-service
         ports:
           - "8081:8081"
         volumes:
           - ./user-management-service:/app
         working_dir: /app
         command: ["java", "-jar", "target/user-management-service-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network

       math-problem-service:
         image: openjdk:21-jre-slim
         container_name: math-problem-service
         ports:
           - "8082:8082"
         volumes:
           - ./math-problem-service:/app
         working_dir: /app
         command: ["java", "-jar", "target/math-problem-service-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network

       solution-evaluation-service:
         image: openjdk:21-jre-slim
         container_name: solution-evaluation-service
         ports:
           - "8083:8083"
         volumes:
           - ./solution-evaluation-service:/app
         working_dir: /app
         command: ["java", "-jar", "target/solution-evaluation-service-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network

       leaderboard-service:
         image: openjdk:21-jre-slim
         container_name: leaderboard-service
         ports:
           - "8084:8084"
         environment:
           MYSQL_ROOT_PASSWORD: root
           MYSQL_DATABASE: leaderboard
           MYSQL_USER: user
           MYSQL_PASSWORD: password
         volumes:
           - ./leaderboard-service:/app
         working_dir: /app
         command: ["java", "-jar", "target/leaderboard-service-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network
         depends_on:
           - mysql

       mysql:
         image: mysql:latest
         container_name: mysql
         environment:
           MYSQL_ROOT_PASSWORD: root
           MYSQL_DATABASE: leaderboard
           MYSQL_USER: user
           MYSQL_PASSWORD: password
         ports:
           - "3306:3306"
         networks:
           - mlp-network
         volumes:
           - mysql-data:/var/lib/mysql

       notification-service:
         image: openjdk:21-jre-slim
         container_name: notification-service
         ports:
           - "8085:8085"
         volumes:
           - ./notification-service:/app
         working_dir: /app
         command: ["java", "-jar", "target/notification-service-0.0.1-SNAPSHOT.jar"]
         networks:
           - mlp-network
         depends_on:
           - rabbitmq

       rabbitmq:
         image: rabbitmq:3-management
         container_name: rabbitmq
         ports:
           - "5672:5672"
           - "15672:15672"
         networks:
           - mlp-network

     networks:
       mlp-network:

     volumes:
       mysql-data:
     ```
   - [ ] Docker Compose configuration file created and services defined.

5. **Run Docker Compose**
   - Start all the microservices using Docker Compose.
   - ```bash
     docker-compose up -d
     ```
   - [ ] Docker Compose started and all services running.

6. **Verify Services**
   - Verify that all services are running correctly.
   - Access the Eureka Server UI at `http://localhost:8761` to see all registered services.
   - Check each microservice endpoint:
     - User Management: `http://localhost:8081`
     - Math Problem: `http://localhost:8082`
     - Solution Evaluation: `http://localhost:8083`
     - Leaderboard: `http://localhost:8084`
     - Notification: `http://localhost:8085`
     - API Gateway: `http://localhost:8080`
   - [ ] Services verified and accessible.

### Development Steps

#### 1. Setup and Initialize the Project

- [ ] Initialize the project with Spring Initializr.
- [ ] Create separate modules for each microservice.
- [ ] Integrate with GitHub for version control.

#### 2. User Management Service

- [ ] Implement user registration using Spring Security.
- [ ] Implement JWT authentication.
- [ ] Create endpoints for user profile management.
- [ ] Implement role-based access control (RBAC).

#### 3. Math Problem Service

- [ ] Create a REST API for math problem management.
- [ ] Setup H2 database for storing problems.
- [ ] Implement CRUD operations for math problems.

#### 4. Solution Evaluation Service

- [ ] Implement a REST API for solution submissions.
- [ ] Setup RabbitMQ for asynchronous processing.
- [ ] Evaluate solutions asynchronously.
- [ ] Return evaluation results to users.

#### 5. Leaderboard Service

- [ ] Define the leaderboard schema and setup MySQL.
- [ ] Implement REST APIs for fetching leaderboard data.
- [ ] Aggregate and display user performance.

#### 6. Notification Service

- [ ] Integrate RabbitMQ for messaging.
- [ ] Implement logic for sending notifications.
- [ ] Test asynchronous notifications.

#### 7. API Gateway

- [ ] Setup Spring Cloud Gateway.
- [ ] Configure request routing to microservices.
- [ ] Implement security measures and rate limiting.

#### 8. Config Server and Service Discovery

- [ ] Setup Spring Cloud Config for centralized configuration.
- [ ] Setup Eureka for service discovery.
- [ ] Register all microservices with Eureka.

#### 9. Implement CI/CD Pipeline

- [ ] Setup GitHub Actions for CI/CD.
- [ ] Create a workflow for building and testing the application.
- [ ] Create Docker images for microservices.
- [ ] Deploy services using Docker Compose.

### Security Considerations

- [ ] Implement JWT-based authentication.
- [ ] Ensure secure communication with HTTPS.
- [ ] Implement CSRF protection.
- [ ] Use secure channels for RabbitMQ.
- [ ] Validate API requests and input data.

### Future Enhancements

- [ ] Extend the platform to support various types of math problems.
- [ ] Add user progress tracking and analytics.
- [ ] Implement more notification channels (e.g., email, SMS).
- [ ] Integrate Kubernetes for container orchestration.
- [ ] Enhance security with advanced monitoring.

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Math Learning Platform (MLP)! Enjoy learning and solving math problems! 🚀
