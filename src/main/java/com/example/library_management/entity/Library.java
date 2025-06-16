package com.example.library_management.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Library {
    private long albumId;
    private String shelfId;
    private String bookId;
    private String bookName;
    private String userName;
    private String userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    private boolean returnCheck;

}