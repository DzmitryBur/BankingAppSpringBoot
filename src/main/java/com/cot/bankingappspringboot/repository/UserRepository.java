package com.cot.bankingappspringboot.repository;

import com.cot.bankingappspringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    List<User> getAllUsers();

    User getUser(long id);

    int createUser(User user);

    void updateUser(User user);

    void deleteUser(long id);
}