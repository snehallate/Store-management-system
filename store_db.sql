CREATE DATABASE store_db;

USE store_db;

CREATE TABLE products (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE,
    quantity INT
);

CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE orders (
    id INT PRIMARY KEY,
    customer_id INT,
    total_amount DOUBLE,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
    id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    subtotal DOUBLE
);
