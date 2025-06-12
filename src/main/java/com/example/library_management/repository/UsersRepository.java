package com.example.library_management.repository;

import org.springframework.stereotype.Repository;

import com.example.library_management.entity.Users;
import com.example.library_management.mapper.UsersMapper;
import com.example.library_management.viewmodel.LibraryViewModel;

import java.util.List;

@Repository
public class UsersRepository {
    private final UsersMapper usersMapperUseNow;

    public UsersRepository(UsersMapper usersMapperUseNow) {
        this.usersMapperUseNow = usersMapperUseNow;
    }

    public List<Users> getAllUsers() {
        return usersMapperUseNow.selectAllUsers();
    }

    public void insertUsers(Users library) {
        usersMapperUseNow.insertUsers(library);
    }

    public Users getUsersById(int usersId) {
        return usersMapperUseNow.selectUsersById(usersId);
    }

    public void deleteUsers(int usersId) {
        usersMapperUseNow.deleteUsersById(usersId);
    }

    public void updateUsers(Users library) {
        usersMapperUseNow.updateUsers(library);
    }
    

}