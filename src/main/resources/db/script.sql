

CREATE SCHEMA `db_docker_practices` ;

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       address VARCHAR(500),
                       phone_no VARCHAR(20)
);