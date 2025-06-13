package com.example.library_management.service;

import org.springframework.stereotype.Service;

import com.example.library_management.entity.Library;
import com.example.library_management.form.LibraryForm;
import com.example.library_management.repository.LibraryRepository;
// import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.getAllLibraries();
    }

    public void createLibrary(LibraryForm libraryForm) {
        Library library = new Library();
        library.setBookId(libraryForm.getBookId());
        library.setBookName(libraryForm.getBookName());
        library.setUserId(libraryForm.getUserId());
        library.setShelfId(libraryForm.getShelfId());
        library.setUserName(libraryForm.getUserName());
        library.setRentalDate(libraryForm.getRentalDate());
        library.setReturnDate(libraryForm.getReturnDate());

        // library.setArtist(libraryForm.getArtist());
        // library.setReleaseDate(libraryForm.getReleaseDate());
        libraryRepository.insertLibrary(library);
    }

    public Library getAllLibraryById(String bookId) {
        return libraryRepository.getLibraryById(bookId);
    }

    public void deleteLibrary(String bookId) {
        libraryRepository.deleteLibrary(bookId);
    }

    public void updateLibrary(String bookId, Library library) {
        if (!bookId.equals(library.getBookId())) {
            throw new IllegalArgumentException("Library ID does not match");
        }
        libraryRepository.updateLibrary(library);
    }

    public List<Library> getLibraries2ById(String bookId) {
        return libraryRepository.getLibraries2ById(bookId);
    }
    
}