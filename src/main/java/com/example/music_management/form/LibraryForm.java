package com.example.music_management.form;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LibraryForm {
    private String bookId;
    private String bookName;
    private String userName;
    private String userId;
    private LocalDate rentalDate;
    private LocalDate returnId;
    private String shelfId;
}
