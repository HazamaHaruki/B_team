package com.example.library_management.repository;

import org.springframework.stereotype.Repository;

import com.example.library_management.entity.Library;
import com.example.library_management.mapper.LibraryMapper;

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

    public Library getLibraryById(long albumId) {
        return libraryMapper.selectLibraryById(albumId);
    }

    public void deleteLibrary(long albumId) {
        libraryMapper.deleteLibraryById(albumId);
    }

    public void updateLibrary(Library library) {
        libraryMapper.updateLibrary(library);
    }

    public List<Library> getLibraries2ById(String bookId){
        return libraryMapper.selectLibraries2ById(bookId);
    }
    
    public void updateReturnCheck(long albumId, boolean returnCheck) {
        libraryMapper.updateReturnCheck(albumId, returnCheck);
    }
public List<Library> getLibraryReturned(boolean returnCheck) {
	return libraryMapper.selectByReturned(returnCheck);
}
}