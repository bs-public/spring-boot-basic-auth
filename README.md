# Spring Boot Basic Authentication

This project demonstrates HTTP Basic Authentication using Spring Boot, Spring Security, MySQL, and Docker.

---

## Getting Started
### Run MySQL with Docker

From the project root, following instructions can be performed:
### To start the container
```bash
  docker compose -f ./docker/compose.yaml up -d
```
### To stop the container
```bash
  docker compose -f ./docker/compose.yaml down
```

---

## Endpoints 

### 1. Health Check
```bash
    curl http://localhost:8080/actuator/health
```

### 2. Register a New User
```bash
    curl -X POST http://localhost:8080/api/auth/register \
      -H "Content-Type: application/json" \
      -d '{"email":"test.user@mail.com","firstName":"Test","lastName":"User","password":"password"}'
```

### 3. Accessing a Protected Endpoint Without Authentication
```bash
  curl http://localhost:8080/api/users/me
```

### 4. Get Own User Info (User Or Admin)
```bash
    curl -u test.user@mail.com:password http://localhost:8080/api/users/me
```

### 5. List All Users (Admin Only)
```bash
    curl -u admin@mail.com:password http://localhost:8080/api/users/all
```
