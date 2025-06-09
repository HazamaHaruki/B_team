package com.example.library_management.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
// import java.time.LocalDateTime;

@Data
public class Library {
    private String shelfId;
    private String bookId;
    private String bookName;
    private String userName;
    private String userId;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;
    private LocalDate returnId;
    

    //private LocalDate releaseDate;
    //private LocalDateTime createdAt;
}