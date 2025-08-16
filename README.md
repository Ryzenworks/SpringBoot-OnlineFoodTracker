# 🍔 Online Food Tracker

A **Spring Boot REST API** to manage food orders — including placing, updating, searching, and cancelling orders.
Initially built with an in-memory `Map<Long, Orders>`, the project has now been **refactored with proper layers (Controller, Service, Model)** for scalability.

---

## 🚀 Features

* **Place Orders** – Add customer name, food items, and initial status.
* **View Orders** – Retrieve all orders or filter by ID/Customer Name.
* **Update Status** – Change the order’s progress (e.g., *Pending → Confirmed → Delivered*).
* **Cancel Orders** – Remove an order from the tracker.
* **Layered Architecture** – Uses **Controller–Service–Model** instead of direct in-memory map calls.
* **Clean Code** – Package structure refactored for maintainability.

---

## 🛠️ Tech Stack

* **Java 8+**
* **Spring Boot 3.x**
* **Maven**
* **REST API (JSON responses)**
* In-Memory Storage (Map) – Database support can be added later

---

## 📂 Project Structure

```
SpringBoot-OnlineFoodTracker/
 ├── src/main/java/com/ryzenworks/foodtracker
 │    ├── controller/     # REST Controllers
 │    ├── service/        # Business Logic
 │    ├── model/          # Order Entity
 │    └── OnlineFoodTrackerApplication.java
 ├── src/test/java/...    # Unit tests
 ├── pom.xml
 └── README.md
```

---

## 📦 Installation & Setup

```bash
# 1️⃣ Clone the repository
git clone https://github.com/Ryzenworks/SpringBoot-OnlineFoodTracker.git
cd SpringBoot-OnlineFoodTracker

# 2️⃣ Build and run the application
mvn spring-boot:run
```

---

## 🔑 API Endpoints

| Method | Endpoint                | Description              |
| ------ | ----------------------- | ------------------------ |
| POST   | `/orders`               | Place a new order        |
| GET    | `/orders`               | Get all orders           |
| GET    | `/orders/{id}`          | Get order by ID          |
| GET    | `/orders/search/{name}` | Search order by customer |
| PUT    | `/orders/{id}`          | Update order status      |
| DELETE | `/orders/{id}`          | Cancel an order          |

---

## ✅ Example Request

**Create an Order**

```http
POST /orders
Content-Type: application/json

{
  "customerName": "John Doe",
  "items": ["Burger", "Fries"],
  "status": "Pending"
}
```

