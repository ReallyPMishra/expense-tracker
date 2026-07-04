# 💰 Expense Tracker - FinTech Capstone Project

A secure **Expense & Budget Tracking System** built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **MySQL**, and **REST APIs**.

The application enables users to manage expenses, categorize transactions, generate monthly reports, and securely access APIs using JWT authentication.

---

# 🚀 Features

* ✅ User Registration & Login
* ✅ JWT Authentication
* ✅ Spring Security Integration
* ✅ Role-Based Access Control (Admin/User)
* ✅ Expense Management (CRUD)
* ✅ Category Management (CRUD)
* ✅ Monthly Expense Reports
* ✅ Expense Validation
* ✅ Global Exception Handling
* ✅ Swagger/OpenAPI Documentation
* ✅ MySQL Database Integration
* ✅ Clean Layered Architecture
* ✅ RESTful APIs

---

# 🛠 Tech Stack

## Backend

* Java 21
* Spring Boot 3.5.x
* Spring MVC
* Spring Data JPA
* Spring Security
* JWT Authentication
* Hibernate

## Database

* MySQL

## Documentation

* Swagger / OpenAPI

## Build Tool

* Maven

---

# 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── exception
├── validation
├── util
├── config
└── resources
```

---

# 🔐 Authentication

The application uses **JWT (JSON Web Token)** for securing REST APIs.

### Authentication Flow

1. Register User
2. Login
3. Receive JWT Token
4. Add Token in Authorization Header
5. Access Protected APIs

Authorization Header

```text
Authorization: Bearer YOUR_JWT_TOKEN
```

---

# 📌 API Endpoints

## Authentication

| Method | Endpoint              | Description   |
| ------ | --------------------- | ------------- |
| POST   | /api/v1/auth/register | Register User |
| POST   | /api/v1/auth/login    | Login User    |

---

## Categories

| Method | Endpoint                |
| ------ | ----------------------- |
| POST   | /api/v1/categories      |
| GET    | /api/v1/categories      |
| GET    | /api/v1/categories/{id} |
| PUT    | /api/v1/categories/{id} |
| DELETE | /api/v1/categories/{id} |

---

## Expenses

| Method | Endpoint              |
| ------ | --------------------- |
| POST   | /api/v1/expenses      |
| GET    | /api/v1/expenses      |
| GET    | /api/v1/expenses/{id} |
| PUT    | /api/v1/expenses/{id} |
| DELETE | /api/v1/expenses/{id} |

---

## Reports

| Method | Endpoint                                          |
| ------ | ------------------------------------------------- |
| GET    | /api/v1/reports/monthly?month={month}&year={year} |

---

# 📊 Monthly Report

The Monthly Report API provides:

* Total Monthly Expense
* Total Transactions
* Category-wise Expense Summary
* Selected Month & Year

Example Response

```json
{
  "month": 7,
  "year": 2026,
  "totalExpense": 12500.0,
  "totalTransactions": 20,
  "categoryWiseExpenses": {
    "Food": 4500.0,
    "Travel": 3000.0,
    "Shopping": 5000.0
  }
}
```

---

# 🔒 Security Features

* JWT Authentication
* Password Encryption using BCrypt
* Role-Based Authorization
* Custom Security Filter
* Secure REST APIs
* Machine-Based License Key Validation(will be add later)

---
# ✅ Validation

Input validation is implemented using Jakarta Validation.

Examples:

* Email Validation
* Password Validation
* Required Fields
* Positive Expense Amount

---

# 📖 Swagger Documentation

After running the project:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# ⚙ Database Configuration

Configure your MySQL database in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=pawan@8908
```

---

# ▶ Running the Project

Clone the repository:

```bash
git clone https://github.com/your-username/expense-tracker.git
```

Navigate to the project:

```bash
cd expense-tracker
```

Build the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

---

# 📸 Future Enhancements

* PDF Report Generation
* Excel Export
* Email Notifications
* Dashboard Analytics
* Charts & Graphs
* Budget Management
* Recurring Expenses
* Docker Deployment
* Cloud Deployment
* Multi-user Expense Sharing

---

# 👨‍💻 Author

**Pawan Kumar Mishra**

**Java Full Stack Developer**

* Java
* Spring Boot
* Spring Security
* REST APIs
* MySQL
* HTML
* CSS
* JavaScript

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.
