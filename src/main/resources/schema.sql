CREATE TABLE libraries (
    book_id VARCHAR(255) PRIMARY KEY,
    book_name VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    user_id VARCHAR(255),
    shelf_id VARCHAR(255),
    rental_date DATE,
    return_date DATE
    
);

