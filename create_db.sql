CREATE DATABASE newsreader_db;

USE newsreader_db;

CREATE TABLE news(
    news_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    url VARCHAR(255) NOT NULL UNIQUE,
    publishedAt BIGINT NOT NULL
);
