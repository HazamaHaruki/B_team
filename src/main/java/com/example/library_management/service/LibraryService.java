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

    public List<Library> getALLLibrarys() {
        return libraryRepository.getAllLibrarys();
    }

    public void createLibrary(LibraryForm libraryForm) {
        Library library = new Library();
        library.setTitle(libraryForm.getTitle());
        library.setArtist(libraryForm.getArtist());
        library.setReleaseDate(libraryForm.getReleaseDate());
        libraryRepository.insertLibrary(library);
    }

    public Library getAllLibraryById(long libraryId) {
        return libraryRepository.getLibraryById(libraryId);
    }

    public void deleteLibrary(long libraryId) {
        libraryRepository.deleteLibrary(libraryId);
    }

    public void updateLibrary(long libraryId, Library library) {
        if (libraryId != library.getLibraryId()) {
            throw new IllegalArgumentException("Library ID does not match");
        }
        libraryRepository.updateLibrary(library);
    }

    public List<LibraryViewModel> getAllLibrarysWithMusicCount() {
        return libraryRepository.getAllLibrarysWithMusicCount();
    }
}