package com.example.library_management.repository;

import org.springframework.stereotype.Repository;

import com.example.library_management.entity.Library;
import com.example.library_management.mapper.LibraryMapper;
// import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

@Repository
public class LibraryRepository {
    private final LibraryMapper libraryMapper;

    public LibraryRepository(LibraryMapper libraryMapper) {
        this.libraryMapper = libraryMapper;
    }

    public List<Library> getAllLibraries() {
        return libraryMapper.selectAllLibraries();
    }

    public void insertLibrary(Library library) {
        libraryMapper.insertLibrary(library);
    }

    public Library getLibraryById(String bookId) {
        return libraryMapper.selectLibraryById(bookId);
    }

    public void deleteLibrary(String bookId) {
        libraryMapper.deleteLibraryById(bookId);
    }

    public void updateLibrary(Library library) {
        libraryMapper.updateLibrary(library);
    }

    public Library getLibraries2ById(String bookId){
        return libraryMapper. selectLibraries2ById(bookId);
    }
    

}