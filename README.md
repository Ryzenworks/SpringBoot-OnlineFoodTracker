# 🍔 Online Food Tracker

A simple Spring Boot REST API that lets you **place, update, search, and cancel food orders**.  
Uses a `Map<Long, Orders>` in memory to store orders without a database.

---

## 🚀 Features

- Place a new order with items and status  
- View all orders  
- Search for an order by **ID** or **Customer Name**  
- Update the order **status**  
- Cancel an order  

---

## 🛠️ Tech Stack

- **Java 8+**
- **Spring Boot**
- **Maven**
- **REST API**
- In-Memory Data Storage (Map)

---

## 📦 Installation & Setup

```bash
# 1️⃣ Clone the repository
git clone https://github.com/your-username/online-food-tracker.git
cd online-food-tracker

# 2️⃣ Build and run the application
mvn spring-boot:run
