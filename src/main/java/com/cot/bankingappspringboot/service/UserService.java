package com.cot.bankingappspringboot.service;

import com.cot.bankingappspringboot.mapper.UserMapper;
import com.cot.bankingappspringboot.model.User;
import com.cot.bankingappspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserRepository {

    JdbcTemplate jdbcTemplate;
    UserMapper userMapper;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM users", userMapper);
    }

    @Override
    public User getUser(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", userMapper, id);
    }

    @Override
    public int createUser(User user) {
        return jdbcTemplate.update("INSERT INTO users(id, name, industry, residency, login, password) VALUES (DEFAULT,?,?,?,?,?)", user.getName(), user.getIndustry(), user.getResidency(), user.getLogin(), user.getPassword());
    }


    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE users SET name = ?, industry =?, residency =?, login =?, password =?  WHERE id = ?", user.getName(), user.getIndustry(), user.getResidency(), user.getLogin(), user.getPassword(), user.getId());
    }


    @Override
    public void deleteUser(long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}
