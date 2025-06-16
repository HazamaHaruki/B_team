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
        library.setAlbumId(libraryForm.getAlbumId());
        library.setBookId(libraryForm.getBookId());
        library.setBookName(libraryForm.getBookName());
        library.setUserId(libraryForm.getUserId());
        library.setShelfId(libraryForm.getShelfId());
        library.setUserName(libraryForm.getUserName());
        library.setRentalDate(libraryForm.getRentalDate());
        library.setReturnDate(libraryForm.getReturnDate());

        libraryRepository.insertLibrary(library);
    }

    public Library getAllLibraryById(long albumId) {
        return libraryRepository.getLibraryById(albumId);
    }

    public void deleteLibrary(long albumId) {
        libraryRepository.deleteLibrary(albumId);
    }

    public void updateLibrary(long albumId, Library library) {
        if (albumId != library.getAlbumId()) {
            throw new IllegalArgumentException("Library ID does not match");
        }
        libraryRepository.updateLibrary(library);
    }

    public List<Library> getLibraries2ById(String bookId) {
        return libraryRepository.getLibraries2ById(bookId);
    }
    
    public void updateReturnCheck(long albumId, boolean returnCheck) {
        libraryRepository.updateReturnCheck(albumId, returnCheck);
    }
}