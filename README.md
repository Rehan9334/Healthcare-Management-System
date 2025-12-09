# 🏥 Healthcare Appointment Management System | Spring Boot + Docker + JUnit + MySQL

A healthcare domain microservice that enables patients to book appointments, 
manage records, and reduce scheduling conflicts with efficient backend logic.

Built using Java & Spring Boot with secure JWT authentication and clean layered architecture.

---

## 🚀 Key Features

✔ Appointment booking & scheduling APIs  
✔ Patient record & health profile management  
✔ JWT authentication-based secure access  
✔ Validations to avoid overlapping appointments  
✔ Docker support for easy deployment  
✔ Unit & integration testing using JUnit + Mockito  
✔ Designed with clean code principles and modular structure  

---

## 🛠 Tech Stack

| Category | Technologies |
|---------|--------------|
| Backend | Java, Spring Boot, Spring Security |
| Database | MySQL |
| Tools | Docker, Postman, Git, IntelliJ IDEA |
| Testing | JUnit, Mockito |
| API Docs | Swagger UI |

---

## 🧩 Core Functionalities

| Module | Description |
|--------|-------------|
| Patient Service | Create & manage patient profiles |
| Appointment Service | Book, reschedule & cancel appointments |
| Auth Module | JWT-based login & role permissions |

---

## 🔐 API Highlights

Example endpoints:
- `POST /auth/login` — JWT + Role validations
- `POST /appointments` — Book appointment
- `GET /appointments/{id}` — View appointment details
- `DELETE /appointments/{id}` — Cancel appointment

Swagger API Docs:


---

## ⚙️ How to Run

### Local Setup

```sh
mvn clean install
mvn spring-boot:run

docker build -t healthcare-service .
docker run -p 8082:8082 healthcare-service
