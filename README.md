# 🍽️ Online Food Tracker

A **RESTful Food Order Tracking System** built with **Spring Boot** and **MongoDB Atlas**, designed to demonstrate secure, scalable backend development practices.  

---

## 🚀 Features

- **User Management**
  - Register new users with secure password handling (BCrypt)
  - Authentication & role-based authorization
  - Profile updates

- **Order Processing**
  - Place, track, and update orders
  - Status lifecycle: `PLACED → COOKING → OUT_FOR_DELIVERY → DELIVERED`
  - Fetch orders by ID or by customer name

- **Admin Dashboard**
  - Manage users and orders
  - Role-based restricted endpoints

- **Security**
  - Spring Security with BCrypt password encryption
  - Role-Based Access Control (RBAC)
  - Stateless authentication (sessionless API design)
  - CSRF protection disabled for API usage

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot 2.7  
- **Database**: MongoDB Atlas (previously local MongoDB)  
- **Security**: Spring Security with BCrypt  
- **API Design**: RESTful architecture with clean endpoint design  
- **Build Tool**: Maven  

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

## 📌 API Endpoints (Sample)

### 👤 User
- `POST /users/register` → Register a new user  
- `POST /users/login` → Login with username & password  
- `PUT /users/update/{userName}` → Update user profile  

### 📦 Orders
- `POST /orders` → Place a new order  
- `GET /orders/{id}` → Get order by ID  
- `GET /orders/customer/{name}` → Get orders by customer name  
- `PUT /orders/{id}/status` → Update order status  

---

## ⚡ Challenges & Solutions

- **BCrypt Password Mismatch** → Fixed by ensuring consistent hashing  
- **CSRF Blocking APIs** → Disabled CSRF for APIs, since authentication is stateless  
- **MongoDB Atlas Connection Errors** → Solved by IP whitelisting & proper URI configuration  
- **Spring Data Queries Confusion** → Learned how Spring auto-generates queries (List vs Optional return types)  

---

## 🎯 Future Enhancements

- JWT Authentication for secure token-based login  
- Email notifications for order updates  
- Docker support for deployment  
- Frontend client for order placement & tracking  


## 🏷️ Tags
`Spring Boot` `MongoDB` `Spring Security` `REST API` `Java` `Backend Development` `Microservices`
