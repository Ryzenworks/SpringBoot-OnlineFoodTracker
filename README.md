# 🍽️ Online Food Tracker

A **RESTful Food Order Tracking System** built with **Spring Boot** and **MongoDB Atlas**, designed to demonstrate secure, scalable backend development practices.

---

## 🚀 Features

* **User Management**

  * Secure user registration with BCrypt
  * Authentication & role-based authorization
  * Profile updates and account deletion

* **Order Processing**

  * Place and manage orders linked to a user
  * Status lifecycle: `PLACED → COOKING → OUT_FOR_DELIVERY → DELIVERED`
  * Fetch orders by ID or by associated user

* **Security**

  * Spring Security with BCrypt password hashing
  * Role-Based Access Control (RBAC)
  * Stateless API authentication
  * CSRF disabled for REST API usage

---

## 🛠️ Tech Stack

* **Backend**: Spring Boot 2.7
* **Database**: MongoDB Atlas (cloud)
* **Security**: Spring Security with BCrypt
* **API Design**: RESTful principles with `@RestController`
* **Build Tool**: Maven

---

## 📂 Project Structure

```
OnlineFoodTracker/
 ┣ src/main/java/com/mohammedmaroof/onlinefoodtracker
 ┃ ┣ Controllers/      # REST Controllers
 ┃ ┣ entity/           # Entities (User, Order, etc.)
 ┃ ┣ repository/       # Spring Data MongoDB Repositories
 ┃ ┣ services/         # Business logic
 ┃ ┣ config/           # Security configuration
 ┃ ┗ FoodTrackerApplication.java
 ┣ src/main/resources
 ┃ ┗ application.properties
 ┣ pom.xml
```

---

## 📌 API Endpoints (Key)

### 🔓 Public

* `GET /public/health-check` → App health status
* `POST /public/create-user` → Register a new user
* `GET /public/search/name/{userName}` → Search user by username

### 👤 Users (Authenticated)

* `GET /users/get-user-details` → Get logged-in user details
* `PUT /users` → Update logged-in user details
* `DELETE /users/delete-user` → Delete logged-in user

### 📦 Orders

* `GET /orders/{userName}` → View all orders for a user
* `POST /orders/{userName}` → Place a new order for a user
* `GET /orders/search/id/{orderId}` → Fetch specific order by ID
* `PUT /orders/update/{userName}/{orderId}` → Update an order
* `DELETE /orders/cancel/{userName}/{orderId}` → Cancel an order

---

## ⚡ Challenges & Solutions

* **BCrypt Password Mismatch** → Fixed by enforcing consistent hashing strategy
* **CSRF Blocking APIs** → Disabled CSRF for stateless REST APIs
* **MongoDB Atlas Connection Issues** → Solved with proper SRV URI and IP whitelisting
* **Query Confusion** → Learned how Spring Data auto-generates queries based on method names

---

## 🏷️ Tags

`Spring Boot` `MongoDB` `Spring Security` `REST API` `Java` `Backend Development` `Microservices`

---
