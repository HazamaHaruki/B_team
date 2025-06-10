package com.example.library_management.viewmodel;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LibraryViewModel {
    private String bookId;
    private String bookName;
    private String userName;
    private String userId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private String shelfId;
}