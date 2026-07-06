# Store-management-system
Repository Link: https://github.com/snehallate/Store-management-system

A modern **Java-based desktop application** developed using **Java Swing** and **MySQL** to efficiently manage store operations such as inventory, customers, orders, and order items.

This project provides an interactive **Graphical User Interface (GUI)** for seamless database operations and demonstrates the implementation of **JDBC connectivity**, **CRUD operations**, and **database management** in Java.



# 📌 Project Overview

The **Store Management System** is designed to simplify store administration by providing a centralized platform to manage:

* 📦 Products & Inventory
* 👥 Customer Records
* 🧾 Orders
* 🛍️ Order Items
* 💾 Database Storage

The application connects to a **MySQL database** and allows users to perform operations through an easy-to-use Java Swing interface.



# ✨ Features

## 📦 Product Management

* Add new products
* Manage product quantity
* Store product pricing details

## 👥 Customer Management

* Add customer information
* Store customer email records

## 🧾 Order Management

* Create customer orders
* Calculate total order amount

## 🛍️ Order Item Management

* Add items to orders
* Maintain subtotal calculations

## 💻 GUI Interface

* User-friendly Java Swing interface
* Structured layouts using GridBagLayout

## 🔗 Database Integration

* MySQL database connectivity using JDBC
* Secure SQL operations using PreparedStatement

## ⚙️ CRUD Operations

* Create Records
* Read Records
* Update Records
* Delete Records

## ❗ Exception Handling

* Handles SQL errors
* Handles invalid user inputs
* Prevents application crashes



# 🛠️ Technologies Used

| Technology      | Description                 |
| --------------- | --------------------------- |
|   Java          | Core programming language   |
|   Java Swing    | GUI development             |
|   MySQL         | Database management         |
|   JDBC          | Database connectivity       |
|   OOP Concepts  | Object-Oriented Programming |



# 🗃️ Database Setup

## Step 1: Open MySQL

Launch MySQL Command Line Client or MySQL Workbench.



## Step 2: Create Database

```sql
CREATE DATABASE store_db;
```


## Step 3: Use Database

```sql
USE store_db;
```



## Step 4: Import SQL File

Import the provided SQL file:

```text
database/store_db.sql
```



# ▶️ How to Run the Project

## Prerequisites

Before running the project, ensure you have:

* Java JDK installed
* MySQL installed
* MySQL JDBC Connector added
* IntelliJ IDEA / Eclipse IDE



## Steps to Execute

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/Store-Management-System.git
```



### 2️⃣ Open Project in IDE

Open the project using:

* IntelliJ IDEA
* Eclipse



### 3️⃣ Add JDBC Connector

Add the MySQL JDBC Connector `.jar` file to project libraries.



### 4️⃣ Configure Database Credentials

Update database details in:

```java
private final String userName = "root";
private final String password = "your_password";
```



### 5️⃣ Run Application

Execute:

```text
StoreManagementSystem.java
```



# 🖥️ GUI Preview

## Main Interface

Add screenshots inside the `screenshots/` folder.

Example:

```md
![GUI](screenshots/gui.png)
```


# 📊 Sample Database Output

## Products Table

```text
+------+----------+--------+----------+
| id   | name     | price  | quantity |
+------+----------+--------+----------+
| 1212 | shampoo  | 219.00 | 50       |
| 1213 | soap     | 65.00  | 50       |
+------+----------+--------+----------+
```
# Output 
<img width="565" height="181" alt="image" src="https://github.com/user-attachments/assets/e317a1d7-3c91-4c48-bfff-e7ece5ec7fe7" />


# 🔄 Workflow

```text
User Input → Java Swing GUI → JDBC Connectivity → MySQL Database
```



# 📖 Concepts Implemented

* Java Swing GUI Design
* JDBC Connectivity
* SQL Queries
* Exception Handling
* Event Handling
* Database Management
* Object-Oriented Programming



# 🚀 Future Enhancements

* 🔍 Product Search Feature
* 📈 Sales Report Generation
* 🔐 User Authentication System
* 🧾 Bill Generation
* 🌐 Online Database Hosting
* 📊 Dashboard Analytics



# 🎯 Learning Outcomes

Through this project, the following concepts were learned and implemented:

* Java GUI Development
* Database Connectivity using JDBC
* SQL Table Management
* Exception Handling Techniques
* Real-world CRUD Application Development


