package com.example.library_management.form;

import lombok.Data;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class LibraryForm {
    private int hitoId;
    private int librariesId;

    private int bookId;
    private String bookName;
    private String userName;
    private int userId;
    private String shelfId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;
    private LocalDate returnDate;
    
}