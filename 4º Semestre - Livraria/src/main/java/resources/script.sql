CREATE DATABASE library;

CREATE TABLE Authors (
 author_id SERIAL PRIMARY KEY,
 name CHAR(25),
 fname CHAR(25)
);

CREATE TABLE Publishers (
 publisher_id SERIAL PRIMARY KEY,
 name CHAR(30),
 url CHAR(80)
);

CREATE TABLE Books (
 title CHAR(60),
 isbn CHAR(13) PRIMARY KEY,
 publisher_id INT,
 price DECIMAL(10,2)
);

CREATE TABLE BooksAuthors (
 isbn CHAR(13),
 author_id INT,
 seq_no INT,
 FOREIGN KEY (isbn) REFERENCES Books (isbn),
 FOREIGN KEY (author_id) REFERENCES Authors
(author_id),
 PRIMARY KEY (isbn, author_id)
);