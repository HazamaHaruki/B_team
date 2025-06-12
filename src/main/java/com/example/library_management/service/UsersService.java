package com.example.library_management.service;

import org.springframework.stereotype.Service;

import com.example.library_management.entity.Libraries;
import com.example.library_management.entity.Users;
import com.example.library_management.form.LibraryForm;
import com.example.library_management.form.UsersForm;
import com.example.library_management.repository.UsersRepository;
import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUsers() {
        return usersRepository.getAllUsers();
    }

    public void createUsers(UsersForm usersForm) {
        Users users = new Users();

        users.setHitoId(usersForm.getHitoId());
        users.setUserName(usersForm.getUserName());

        // library.setArtist(libraryForm.getArtist());
        // library.setReleaseDate(libraryForm.getReleaseDate());
        usersRepository.insertUsers(users);
    }

    public Users getAllUsersById(int hitoId) {
        return usersRepository.getUsersById(hitoId);
    }

    public void deleteUsers(int hitoId) {
        usersRepository.deleteUsers(hitoId);
    }

    public void updateUsers(int hitoId, Users users) {
        if (hitoId != users.getHitoId()) {
            throw new IllegalArgumentException("Users ID does not match");
        }
        usersRepository.updateUsers(users);
    }

    
}