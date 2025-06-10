package com.example.library_management.service;

import org.springframework.stereotype.Service;

import com.example.library_management.entity.Library;
import com.example.library_management.form.LibraryForm;
import com.example.library_management.repository.LibraryRepository;
import com.example.library_management.viewmodel.LibraryViewModel;

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

        // library.setArtist(libraryForm.getArtist());
        // library.setReleaseDate(libraryForm.getReleaseDate());
        libraryRepository.insertLibrary(library);
    }

    public Library getAllLibraryById(long albumId) {
        return libraryRepository.getLibraryById(albumId);
    }

    public void deleteLibrary(long albumId) {
        libraryRepository.deleteLibrary(albumId);
    }

    public void updateLibrary(String albumId, Library library) {
        if (albumId != library.getBookId()) {
            throw new IllegalArgumentException("Library ID does not match");
        }
        libraryRepository.updateLibrary(library);
    }

    
}