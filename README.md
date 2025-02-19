# Spring Boot Microservices Project

## Overview
This project is a microservices-based application built using Java Spring Boot. It leverages various technologies for authentication, messaging, monitoring, and frontend development.

## Tech Stack
- **Backend:** Java Spring Boot
- **Database:** MySQL
- **Frontend:** React.js
- **Authentication:** Keycloak
- **Message Broker:** Apache Kafka
- **Monitoring:** Grafana, Prometheus

## Features
- Microservices architecture for scalability and maintainability.
- Secure authentication and authorization using Keycloak.
- Event-driven communication between services using Kafka.
- Real-time monitoring with Prometheus and visualization with Grafana.
- Frontend developed using React.js for a seamless user experience.

## Microservices
The project consists of multiple microservices, each handling a specific domain:

1. **User Service**: Manages user authentication, registration, and profile management.
2. **Product Service**: Handles product catalog, inventory, and details.
3. **Order Service**: Manages order processing, payments, and tracking.
4. **Notification Service**: Sends notifications using Kafka message queues.

## System Architecture
The system follows a distributed microservices architecture with the following key components:

- **API Gateway:** Centralized entry point for routing requests to appropriate microservices.
- **Service Registry & Discovery:** Ensures dynamic discovery of services.
- **Database per Microservice:** Each microservice has its own MySQL database.
- **Event-driven communication:** Kafka facilitates asynchronous event messaging.
- **Monitoring Stack:** Prometheus collects metrics, and Grafana visualizes them.

## Installation & Setup

### Prerequisites
- Java 17+
- Node.js & npm (for React frontend)
- Docker (optional, for containerization)
- MySQL database
- Keycloak server
- Apache Kafka
- Prometheus & Grafana

### Backend Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo.git
   cd your-repo
   ```
2. Configure MySQL in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```
3. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the React frontend directory:
   ```sh
   cd frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the development server:
   ```sh
   npm start
   ```

### Keycloak Configuration
1. Start Keycloak and create a realm.
2. Define clients and roles for authentication.
3. Update the backend to integrate Keycloak security configurations.

### Kafka Setup
1. Start Zookeeper:
   ```sh
   bin/zookeeper-server-start.sh config/zookeeper.properties
   ```
2. Start Kafka:
   ```sh
   bin/kafka-server-start.sh config/server.properties
   ```

### Monitoring Setup
1. Start Prometheus:
   ```sh
   prometheus --config.file=prometheus.yml
   ```
2. Start Grafana and configure dashboards.

## Deployment
- The application can be deployed using Docker Compose or Kubernetes.
- CI/CD pipelines can be set up for automated deployments.

## Contributing
- Fork the repository and create feature branches.
- Follow coding best practices and ensure code quality.
- Submit pull requests with detailed descriptions.

## License
This project is licensed under the MIT License.

