package com.example.library_management.repository;

import org.springframework.stereotype.Repository;

import com.example.library_management.entity.Libraries;
import com.example.library_management.mapper.librariesMapper;
import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

@Repository
public class LibraryRepository {
    private final librariesMapper librariesMapperUseNow;

    public LibraryRepository(librariesMapper librariesMapperUseNow) {
        this.librariesMapperUseNow = librariesMapperUseNow;
    }

    public List<Libraries> getAllLibraries() {
        return librariesMapperUseNow.selectAllLibraries();
    }

    public void insertLibrary(Libraries library) {
        librariesMapperUseNow.insertLibrary(library);
    }

    public Libraries getLibraryById(int librariesId) {
        return librariesMapperUseNow.selectLibraryById(librariesId);
    }

    public void deleteLibrary(int librariesId) {
        librariesMapperUseNow.deleteLibraryById(librariesId);
    }

    public void updateLibrary(Libraries library) {
        librariesMapperUseNow.updateLibrary(library);
    }
    

}