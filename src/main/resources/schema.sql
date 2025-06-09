CREATE TABLE libraries (
    book_id int PRIMARY,
    book_name VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    user_id VARCHAR(255),
    rental_date DATE,
    return_id DATE,
    shelf_id : varchar(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/*CREATE TABLE musics (
    music_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration TIME,
    album_id INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (album_id) REFERENCES albums(album_id) ON DELETE CASCADE
);*/

/*CREATE TABLE users (
    user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);*/