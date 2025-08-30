
# Online Food Tracker

## Overview
Online Food Tracker is a Spring Boot application that provides a comprehensive platform for tracking and managing food orders. The system allows users to place orders, track their status, and manage their profiles securely.

## Technologies Used
- Java 8
- Spring Boot 2.7
- MongoDB Atlas Cloud
- Spring Security
- Maven
- Spring Data MongoDB

## Features

### User Management
- **User Registration**: Create new user accounts securely
- **Authentication**: Secure login with Spring Security and BCrypt password encryption
- **Profile Management**: Users can view and update their profile information
- **Account Deletion**: Users can delete their accounts when needed

### Order Management
- **Place Orders**: Users can create new food orders with multiple items
- **Track Order Status**: Orders can be tracked through various states:
  - PLACED
  - COOKING
  - OUT_FOR_DELIVERY
  - DELIVERED
- **Order History**: Users can view their complete order history
- **Order Updates**: Modify existing orders (items, customer name)
- **Order Cancellation**: Cancel orders that haven't been delivered

### Security Features
- **BCrypt Password Encryption**: Secure storage of user credentials
- **HTTP Basic Authentication**: Stateless authentication mechanism
- **CSRF Protection**: Protection against Cross-Site Request Forgery attacks
- **Endpoint Security**: Role-based access control for API endpoints

## API Endpoints

### Public Endpoints
```
GET /public/health-check: Check if the application is running
POST /public/create-user: Register a new user
GET /public/search/name/{userName}: Search for a user by username
```

### User Endpoints (Authenticated)
```
GET /users/get-user-details: Get current user details
PUT /users: Update user information
DELETE /users/delete-user: Delete current user account
```

### Order Endpoints (Authenticated)
```
GET /orders/{userName}: Get all orders for a user
POST /orders/{userName}: Place a new order
GET /orders/search/id/{orderId}: Get a specific order by ID
PUT /orders/update/{userName}/{orderId}: Update an existing order
DELETE /orders/cancel/{userName}/{orderId}: Cancel an order
```

## Technical Implementation
- **MongoDB Transactions**: Ensures data consistency across operations
- **RESTful API Design**: Well-structured endpoints following REST principles
- **Document-based Data Model**: Efficient schema design for MongoDB
- **Exception Handling**: Comprehensive error handling with appropriate HTTP status codes
- **Stateless Architecture**: Designed for scalability

## Setup and Installation

### Prerequisites
- Java 8 or higher
- Maven
- MongoDB Atlas account (or local MongoDB instance)

### Configuration
Update the `application.properties` file with your MongoDB connection details:

```properties
spring.data.mongodb.uri=your_mongodb_connection_string
spring.data.mongodb.database=your_database_name
spring.data.mongodb.auto-index-creation=true
```

### Building the Application
```bash
mvn clean install
```

### Running the Application
```bash
mvn spring-boot:run
```
```

You can save this as a README.md file in your project root directory.
        
