package com.example.library_management.service;

import org.springframework.stereotype.Service;

import com.example.library_management.entity.Libraries;
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

    public List<Libraries> getAllLibraries() {
        return libraryRepository.getAllLibraries();
    }

    public void createLibrary(LibraryForm libraryForm) {
        Libraries library = new Libraries();
        library.setLibrariesId(libraryForm.getLibrariesId());
        library.setBookName(libraryForm.getBookName());
        library.setShelfId(libraryForm.getShelfId());

        // library.setArtist(libraryForm.getArtist());
        // library.setReleaseDate(libraryForm.getReleaseDate());
        libraryRepository.insertLibrary(library);
    }

    public Libraries getAllLibraryById(int librariesId) {
        return libraryRepository.getLibraryById(librariesId);
    }

    public void deleteLibrary(int librariesId) {
        libraryRepository.deleteLibrary(librariesId);
    }

    public void updateLibrary(int librariesId, Libraries library) {
        if (librariesId != library.getLibrariesId()) {
            throw new IllegalArgumentException("Library ID does not match");
        }
        libraryRepository.updateLibrary(library);
    }

    
}