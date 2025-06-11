package com.example.library_management.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
// import java.time.LocalDateTime;

@Data
public class Library {
    private int hitoId;
    private int librariesId;

    private int bookId;
    private String bookName;
    private String userName;
    private int userId;
    private String shelfId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    //private LocalDate releaseDate;
    //private LocalDateTime createdAt;
}