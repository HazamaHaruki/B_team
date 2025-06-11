create table libraries(
  libraries_id Integer AUTO_INCREMENT PRIMARY KEY,
  book_name VARCHAR(255),
  shelf_id VARCHAR(255)
  );
  
  create table users(
  hito_id Integer PRIMARY KEY,
  user_name VARCHAR(255) NOT NULL
  );
  
  create table dates(
  	user_id Integer PRIMARY KEY,
    rental_date DATE,
  	return_date DATE,
  	book_id Integer
  );

CREATE TABLE LogIn(
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


