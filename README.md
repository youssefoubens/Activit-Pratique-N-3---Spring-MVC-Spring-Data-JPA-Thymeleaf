# 🏥 Patient Management Application

A **Spring Boot** web application for managing patients using **Spring MVC**, **Thymeleaf**, and **Spring Data JPA**.

### ✨ Features
- 📄 View all patients
- 📌 Paginate through patient records
- 🔎 Search for patients by name
- ❌ Delete a patient
- 🛠️ System extensibility for improvements

---

## 🚀 Technologies Used

- **Java 21+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **Bootstrap** (UI)
- **H2** / **MySQL** (Database)

---

## 📸 Screenshots

### 🏠 Project Structure – List of Patients
![Project Structure](images/projectstructur.png)

### 🛠️ H2 Configuration
Configure your `application.properties` like so:  
![H2 Configuration](images/img_1.png)

Access H2 Console via:  
`http://localhost:8086/h2-console` (check your configured port)  
![H2 Console](images/img.png)

Example database view:  
![Database](images/img_2.png)

---

### ➕ Add Patients to H2 Database
![Add Patients](images/addsomepatient.png)

---

### 🧩 Add Thymeleaf and Bootstrap
Include dependencies via [Maven Central](https://mvnrepository.com/) in your `pom.xml`:  
![Add Dependencies](images/img_3.png)

---

### 📂 Link Controller to View
Controllers map to views in `src/main/resources/templates/` based on `@RequestMapping`.

---

### 📋 Get All Patients
![Get All Patients](images/img_5.png)

---

### ➕ Add New Patients
![Add Patients](images/img_6.png)

<!--
### ❌ Delete a Patient  
![Delete Patient](screenshots/delete.png)
-->

---

## 🔐 Security Features

- 🔒 Spring Security authentication
- 👤 Dynamic user display in navbar
- 🛡️ CSRF protection
- 🔑 Password encryption (BCrypt)
- 👥 Role-based access:
    - `USER`: Manage patients
    - `ADMIN`: Full access

**Login Interface:**  
![Security Sign-In](images/img_8.png)

**User Info in Navbar:**  
![Navbar](images/img_7.png)

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/youssefoubens/Activit-Pratique-N-3---Spring-MVC-Spring-Data-JPA-Thymeleaf.git
