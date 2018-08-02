CREATE DATABASE newsreader_db;

USE newsreader_db;

CREATE TABLE news(
    news_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    description TEXT,
    url VARCHAR(255),
    publishedAt INT
);
