## Math Learning Platform - Microservice Java

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

1. **Setup and Initialize the Project**

   - [ ] Initialize each microservice project with Spring Initializr, selecting the necessary dependencies for each service, such as:
     - For User Management Service: Spring Web, Spring Security, Spring Data JPA, MySQL Driver
     - For Math Problem Service: Spring Web, Spring Data JPA, H2 Database
     - For Solution Evaluation Service: Spring Web, Spring Boot DevTools, RabbitMQ
     - For Leaderboard Service: Spring Web, Spring Data JPA, MySQL Driver
     - For Notification Service: Spring Web, Spring Boot DevTools, RabbitMQ
     - For API Gateway: Spring Cloud Gateway, Spring Boot DevTools, Spring Security
     - For Config Server: Spring Cloud Config Server, Spring Boot DevTools
     - For Eureka Server: Spring Cloud Eureka Server, Spring Boot DevTools
   - [ ] Create separate modules for each microservice within the project structure.
   - [ ] Integrate the project with GitHub for version control, ensuring each microservice has its repository.

2. **User Management Service**

   - [ ] Implement user registration using Spring Security, including:
     - User entity with attributes like username, email, password.
     - Registration endpoint with validation and encryption of passwords.
   - [ ] Implement JWT authentication for secure user login and access token generation.
   - [ ] Create REST API endpoints for user profile management, including:
     - Endpoint for retrieving user details.
     - Endpoint for updating user information.
   - [ ] Implement role-based access control (RBAC) to manage user privileges.

3. **Math Problem Service**

   - [ ] Design and create a REST API for math problem management, including:
     - Endpoints for creating, reading, updating, and deleting math problems.
   - [ ] Setup H2 database for storing math problems temporarily during development.
   - [ ] Implement CRUD operations for math problems, ensuring proper validation and error handling.

4. **Solution Evaluation Service**

   - [ ] Develop a REST API for solution submissions, including:
     - Endpoint for submitting user solutions with problem ID and solution data.
   - [ ] Setup RabbitMQ for asynchronous processing of solution evaluations.
   - [ ] Implement asynchronous solution evaluation logic, ensuring scalability and performance.
   - [ ] Return evaluation results to users through appropriate endpoints.

5. **Leaderboard Service**

   - [ ] Define the schema for the leaderboard and set up MySQL for persistent storage.
   - [ ] Implement REST APIs for fetching leaderboard data, including:
     - Endpoint for retrieving the overall leaderboard.
     - Endpoint for fetching user-specific ranking and performance data.
   - [ ] Aggregate and display user performance metrics based on their activity and solution submissions.

6. **Notification Service**

   - [ ] Integrate RabbitMQ for messaging between microservices.
   - [ ] Implement logic for sending notifications to users based on various events, such as:
     - New problem availability.
     - Solution evaluation results.
   - [ ] Test asynchronous notification functionality to ensure reliability and performance.

7. **API Gateway**

   - [ ] Setup Spring Cloud Gateway to act as the single entry point for all client requests.
   - [ ] Configure request routing to microservices based on predefined rules and patterns.
   - [ ] Implement security measures such as JWT token validation and rate limiting to protect the APIs.

8. **Config Server and Service Discovery**

   - [ ] Configure and set up Spring Cloud Config Server for centralized configuration management.
   - [ ] Setup Eureka Server for service registration and discovery, ensuring each microservice is registered.
   - [ ] Register all microservices with Eureka to enable dynamic service discovery and communication.

9. **Implement CI/CD Pipeline**

   - [ ] Setup GitHub Actions for continuous integration and continuous deployment.
   - [ ] Create a workflow for building and testing the application on each push to the repository.
   - [ ] Build Docker images for each microservice and publish them to a container registry.
   - [ ] Deploy services using Docker Compose, ensuring all dependencies are correctly configured.

10. **Security Considerations**

    - [ ] Implement JWT-based authentication for secure user authentication and authorization.
    - [ ] Ensure secure communication between microservices and clients using HTTPS.
    - [ ] Implement Cross-Site Request Forgery (CSRF) protection to prevent unauthorized requests.
    - [ ] Use secure channels and encryption for RabbitMQ communication to prevent data breaches.
    - [ ] Validate API requests and input data to mitigate security vulnerabilities like injection attacks.

11. **Future Enhancements**

    - [ ] Extend the platform to support various types of math problems, including algebra, geometry, and calculus.
    - [ ] Add user progress tracking and analytics functionality to monitor user performance and improvement.
    - [ ] Implement additional notification channels such as email and SMS to enhance user engagement.
    - [ ] Integrate Kubernetes for container orchestration to ensure scalability and reliability.
    - [ ] Enhance security measures with advanced monitoring tools and practices to detect and prevent security threats effectively.

### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Math Learning Platform (MLP)! Enjoy learning and solving math problems! 🚀
