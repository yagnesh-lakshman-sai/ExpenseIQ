# 💰 ExpenseIQ

A full-stack expense management application built using **Java, Spring Boot, Spring Data JPA, MySQL, Thymeleaf, Bootstrap, and REST APIs**. The application helps users manage daily expenses by organizing them into categories and tracking spending efficiently.

---

## 🚀 Features

- User Management (CRUD)
- Category Management (CRUD)
- Expense Management (CRUD)
- Layered Architecture
- Global Exception Handling
- DTO Support
- MySQL Database Integration
- Schema Initialization using `schema.sql`
- Sample Data Seeding using `data.sql`
- REST APIs with Postman Testing
- Swagger API Documentation
- Thymeleaf Frontend Pages
- Bootstrap Responsive UI
- Shared Navigation Bar using Thymeleaf Fragments

---

## 🛠 Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- MySQL
- Lombok

### Frontend
- Thymeleaf
- HTML5
- CSS3
- Bootstrap 5
- JavaScript

### Tools
- Postman
- Maven
- Git
- GitHub
- Swagger OpenAPI

---

## 📂 Project Structure

```text
Smart-Expense-Analyzer
│
├── controller
├── service
│   └── impl
├── repository
├── model
├── dto
├── exception
├── config
├── util
│
├── resources
│   ├── templates
│   │   ├── dashboard.html
│   │   ├── users.html
│   │   ├── categories.html
│   │   ├── expenses.html
│   │   ├── add-expense.html
│   │   └── fragments
│   │       └── navbar.html
│   │
│   ├── static
│   │   ├── css
│   │   └── js
│   │
│   ├── application.properties
│   ├── schema.sql
│   └── data.sql
```

---

## 🗄 Database Schema

### User
- id
- name
- email
- password

### Category
- id
- name

### Expense
- id
- description
- amount
- date
- user_id
- category_id

---

## 🔗 Entity Relationships

- One User → Many Expenses
- One Category → Many Expenses
- Many Expenses → One User
- Many Expenses → One Category

---

## 🌐 REST API Endpoints

### Users

| Method | Endpoint |
|----------|----------|
| GET | /api/users |
| GET | /api/users/{id} |
| POST | /api/users |
| PUT | /api/users/{id} |
| DELETE | /api/users/{id} |

### Categories

| Method | Endpoint |
|----------|----------|
| GET | /api/categories |
| GET | /api/categories/{id} |
| POST | /api/categories |
| PUT | /api/categories/{id} |
| DELETE | /api/categories/{id} |

### Expenses

| Method | Endpoint |
|----------|----------|
| GET | /api/expenses |
| GET | /api/expenses/{id} |
| POST | /api/expenses |
| PUT | /api/expenses/{id} |
| DELETE | /api/expenses/{id} |

---

## 🎨 Frontend Pages

| Page | URL |
|-------|-----|
| Dashboard | http://localhost:8085/ |
| Users | http://localhost:8085/users-page |
| Categories | http://localhost:8085/categories-page |
| Expenses | http://localhost:8085/expenses-page |
| Add Expense | http://localhost:8085/add-expense-page |

---

## ⚙️ Running the Project

### Clone Repository

```bash
git clone https://github.com/your-username/Smart-Expense-Analyzer.git
```

### Navigate

```bash
cd Smart-Expense-Analyzer
```

### Configure Database

Update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/smart_expense_db
spring.datasource.username=root
spring.datasource.password=your_password
```

### Run

```bash
mvn spring-boot:run
```

Application will start at:

```text
http://localhost:8085
```
## 🔮 Future Enhancements

- Spring Security + JWT Authentication
- Monthly Expense Analytics
- Filter Expenses by Category and Date
- Dashboard Charts
- Export to Excel/PDF
- Docker Support
- Microservices Architecture
- AWS Deployment

---

## 📌 Learning Outcomes

- Spring Boot Layered Architecture
- REST API Development
- JPA Entity Relationships
- Exception Handling
- Database Design
- DTO Pattern
- Swagger Documentation
- Thymeleaf Integration
- CRUD Operations
- Full Stack Application Development

---

## 👨‍💻 Author
**Yagnesh Lakshman Sai Dangudubiyyam**
