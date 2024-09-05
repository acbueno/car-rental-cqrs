# Car Rental CQRS

This project is a Car Rental system implemented using the Command Query Responsibility Segregation (CQRS) pattern. The system allows you to manage cars, customers, and car allocations separately for better scalability and maintainability.

## Features

- **Car Management**
  - Register new cars available for rental.
  - Update car information.
  - List all cars, filter by availability, type, or category.

- **Customer Management**
  - Register new customers.
  - Update customer details.
  - View customer information.

- **Car Allocation**
  - Allocate cars to customers.
  - Calculate rental cost based on the car's price per day and rental duration.
  - Deallocate cars after rental completion.

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Data JPA** (H2 Database for Command and Caffeine Cache for Query)
- **ModelMapper** (for DTO mapping)
- **Spring Cache** (with Caffeine for caching)
- **CQRS** (Command Query Responsibility Segregation pattern)
- **JUnit 5** (for testing)

## Project Structure

The project is divided into two main parts:

- **Command Side**: Handles all operations that modify the state of the system.
  - **Entities**: Contains the entities representing the business model.
  - **Repositories**: Manages database operations for entities.
  - **Services**: Contains the business logic for commands.
  - **Controllers**: Exposes REST APIs for commands.

- **Query Side**: Handles all operations that read data from the system.
  - **Entities**: Same as in the command side, but optimized for querying.
  - **Repositories**: Manages database operations for entities.
  - **Services**: Contains the business logic for queries.
  - **Controllers**: Exposes REST APIs for queries.

## Endpoints

### Car Management

- **Get All Cars**: `GET /api/queries/cars`
- **Get Car by ID**: `GET /api/queries/cars/{id}`
- **Get All Cars by Type**: `GET /api/queries/cars/type/{type}`
- **Get All Cars by Category**: `GET /api/queries/cars/category/{category}`
- **Get All Cars by Availability**: `GET /api/queries/cars/available`
- **Add New Car**: `POST /api/commands/cars`
- **Update Car**: `PUT /api/commands/cars/{id}`
- **Delete Car**: `DELETE /api/commands/cars/{id}`

### Customer Management

- **Get All Customers**: `GET /api/queries/customers`
- **Get Customer by ID**: `GET /api/queries/customers/{id}`
- **Add New Customer**: `POST /api/commands/customers`
- **Update Customer**: `PUT /api/commands/customers/{id}`
- **Delete Customer**: `DELETE /api/commands/customers/{id}`

### Car Allocation

- **Allocate Car to Customer**: `POST /api/commands/allocate`
- **Get Allocation by ID**: `GET /api/queries/allocations/{id}`
- **Deallocate Car**: `POST /api/commands/deallocate`

## Setup and Installation

### Prerequisites

- **Java 17**
- **Maven**

### Steps

1. Clone the repository:

    ```sh
    git clone https://github.com/acbueno/car-rental-cqrs.git
    cd car-rental-cqrs
    ```

2. Build the project:

    ```sh
    mvn clean install
    ```

3. Run the application:

    ```sh
    mvn spring-boot:run
    ```

4. Access the application:

    - API Documentation: `http://localhost:8080/swagger-ui.html`
    - H2 Console: `http://localhost:8080/h2-console`

## Testing

The project includes unit tests for all services and controllers. To run the tests:

```sh
mvn test
