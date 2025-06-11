package com.example.library_management.viewmodel;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LibraryViewModel {

    private int hitoId;
    private int librariesId;

    private int bookId;
    private String bookName;
    private String userName;
    private int userId;
    private String shelfId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    
}