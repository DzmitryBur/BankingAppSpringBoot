package com.cot.bankingappspringboot.controller;

import com.cot.bankingappspringboot.model.User;
import com.cot.bankingappspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable long id){

        return userService.getUser(id);
    }

    @PostMapping
    User createUser(@RequestBody User user) {

        return userService.createUser(HttpStatus.CREATED);
    }

    @PutMapping
    User updateUser(@RequestBody User user) {
        return userService.updateUser(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    User deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

}
