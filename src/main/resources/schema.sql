CREATE TABLE libraries (
    album_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    book_id VARCHAR(255) ,
    book_name VARCHAR(255) ,
    user_name VARCHAR(255) ,
    user_id VARCHAR(255),
    shelf_id VARCHAR(255),
    rental_date DATE,
    return_date DATE   
);


CREATE TABLE users (
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


