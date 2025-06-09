package com.example.library_management.repository;

import org.springframework.stereotype.Repository;

import com.example.library_management.entity.Library;
import com.example.library_management.mapper.LibraryMapper;
import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

@Repository
public class LibraryRepository {
    private final LibraryMapper libraryMapper;

    public LibraryRepository(LibraryMapper libraryMapper) {
        this.libraryMapper = libraryMapper;
    }

    public List<Library> getAllLibrarys() {
        return libraryMapper.selectAllLibrarys();
    }

    public void insertLibrary(Library library) {
        libraryMapper.insertLibrary(library);
    }

    public Library getLibraryById(long libraryId) {
        return libraryMapper.selectLibraryById(libraryId);
    }

    public void deleteLibrary(long libraryId) {
        libraryMapper.deleteLibraryById(libraryId);
    }

    public void updateLibrary(Library library) {
        libraryMapper.updateLibrary(library);
    }

    public List<LibraryViewModel> getAllLibrarysWithMusicCount() {
        return libraryMapper.selectAllLibrarysWithMusicCount();
    }

}

