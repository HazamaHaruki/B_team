package com.example.library_management.form;

import lombok.Data;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class LibraryForm {
    private int albumId;
    private String bookId;
    private String bookName;
    private String userName;
    private String userId;
    private String shelfId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;
    private LocalDate returnDate;
    
}