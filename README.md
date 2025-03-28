# 🏥 Patient Management Application

This is a **Spring Boot** web application for managing patients using **Spring MVC, Thymeleaf, and Spring Data JPA**.  
The application allows users to:
- 📄 **View all patients**
- 📌 **Paginate through patient records**
- 🔎 **Search for patients by name**
- ❌ **Delete a patient**
- 🛠️ **Enhance the system with improvements**

---

## 🚀 Technologies Used
- **Java 21+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **Bootstrap (for UI)**
- **H2/MySQL (Database)**

---

## 📸 Screenshots

### 🏠 Project Structure - List of Patients

![Project Structure](images/projectstructur.png)

### H2 Configuration
In your `application.properties`, configure it like this:

![H2 Configuration](images/img_1.png)

Run the app at `http://localhost:8086/h2-console` (depending on the port you configure in your `application.properties`):

![H2 Console](images/img.png)

The database should look like this:

![Database](images/img_2.png)

### 📌 Add Some Patients to H2 Database

![Add Patients](images/addsomepatient.png)

### Add Thymeleaf and Bootstrap to Your Project
Go to Maven repository and copy the necessary dependencies into your `pom.xml`:

![Add Dependencies](images/img_3.png)

### Link Your Controller to the View
Your controller will map to the corresponding view in `src/main/resources/templates/`, based on your controller's `@RequestMapping`:

### 🔎 Get All Patients

![Get All Patients](images/img_5.png)

### + add Patients
![add Patients](images/img_6.png)

[//]: # ()
[//]: # (### ❌ Delete a Patient)
[//]: # (![Delete Patient]&#40;screenshots/delete.png&#41;)

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/youssefoubens/Activit-Pratique-N-3---Spring-MVC-Spring-Data-JPA-Thymeleaf.git
