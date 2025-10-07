# 🏗️ BuildSmart – Project & Task Management Module

## 📌 Overview

**BuildSmart** is a Construction Management System.
This module focuses on **Projects** and **Tasks**, providing a backend built with **Spring Boot + SQL Server** and a frontend built using **Bootstrap 5 + JavaScript**.

It allows managers to:

* Create and manage projects
* Assign tasks to teams
* Track project progress and deadlines
* Edit or delete tasks dynamically

---

## ✨ Features

✅ Create, view, update, and delete **Projects**
✅ Assign multiple **Tasks** to a project
✅ Edit or delete tasks via dynamic frontend UI
✅ Bootstrap 5 responsive frontend (projects.html, project_details.html)
✅ SQL Server database integration
✅ REST API endpoints for full CRUD operations

---

## 🗄️ Database Schema

### `Projects` Table

| Column        | Type     | Notes                                |
| ------------- | -------- | ------------------------------------ |
| `Id`          | bigint   | Primary Key (auto)                   |
| `ProjectName` | nvarchar | Project title                        |
| `Location`    | nvarchar | Project location                     |
| `Email`       | nvarchar | Contact email                        |
| `Status`      | nvarchar | (Planning/Ongoing/Completed/Delayed) |
| `StartDate`   | date     | Start date                           |
| `EndDate`     | date     | End date                             |
| `Budget`      | decimal  | Project budget                       |
| `Description` | nvarchar | Project description                  |

### `Tasks` Table

| Column        | Type     | Notes                                           |
| ------------- | -------- | ----------------------------------------------- |
| `Id`          | bigint   | Primary Key (auto)                              |
| `TaskName`    | nvarchar | Task title                                      |
| `Description` | nvarchar | Task details                                    |
| `DueDate`     | date     | Deadline                                        |
| `AssignedTo`  | nvarchar | Assigned team/person                            |
| `Status`      | nvarchar | Not Started / Pending / In Progress / Completed |
| `ProjectId`   | bigint   | FK → Projects(Id)                               |

---

## ⚙️ Tech Stack

* **Backend:** Java 17, Spring Boot 3, Spring Data JPA, Hibernate
* **Database:** Microsoft SQL Server
* **Frontend:** HTML5, CSS3, Bootstrap 5, Vanilla JavaScript
* **Build Tool:** Maven

---

## 🚀 Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/buildsmart.git
cd buildsmart
```

### 2️⃣ Configure Database

Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=BuildSmart
spring.datasource.username=sa
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=none
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

### 3️⃣ Run the Backend

```bash
mvn spring-boot:run
```

### 4️⃣ Access Frontend

Open in browser:

```
http://localhost:8080/projects.html
http://localhost:8080/project_details.html?id=1
```

---

## 🔗 API Endpoints

### Projects

* `GET /api/projects` → Get all projects
* `GET /api/projects/{id}` → Get project by ID
* `POST /api/projects` → Create project
* `PUT /api/projects/{id}` → Update project
* `DELETE /api/projects/{id}` → Delete project

### Tasks

* `GET /api/projects/{projectId}/tasks` → Get tasks for project
* `POST /api/projects/{projectId}/tasks` → Add task to project
* `PUT /api/projects/{projectId}/tasks/{taskId}` → Update task
* `DELETE /api/projects/{projectId}/tasks/{taskId}` → Delete task

---

## 📸 Screenshots

> *(Add screenshots of your `projects.html` and `project_details.html` UI here)*

---

## 👨‍💻 Author

* **Nadeesha D Shalom**
  *Software Engineering Undergraduate | IoT & Web Projects Enthusiast*
  🔗 [GitHub](https://github.com/Nadeesha-D-Shalom) • [LinkedIn](https://www.linkedin.com/in/nadeesha-shalom-a5a2a4251/)

---

## 📜 License

This project is licensed under the MIT License – feel free to use and modify it.

---
