package com.cot.bankingappspringboot.controller;

import com.cot.bankingappspringboot.model.Role;
import com.cot.bankingappspringboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> list = roleService.getAllRoles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    Role getRole(@PathVariable long id){

        return roleService.getRole(id);
    }

    @PostMapping
    ResponseEntity<HttpStatus> createRole(@RequestBody Role role) {
        roleService.createRole(role);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<HttpStatus> updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);
    }

}
