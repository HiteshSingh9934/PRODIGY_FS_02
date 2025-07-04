CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;

-- Table for admin users
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- Table for employees
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    salary DECIMAL(10, 2) NOT NULL
);

-- Insert default admin user
INSERT IGNORE INTO users (username, password) VALUES ('admin', 'admin123');
