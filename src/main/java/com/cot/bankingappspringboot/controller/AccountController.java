package com.cot.bankingappspringboot.controller;

import com.cot.bankingappspringboot.model.Account;
import com.cot.bankingappspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> list = accountService.getAllAccounts();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    Account getAccount(@PathVariable long id){

        return accountService.getAccount(id);
    }

     @PostMapping
    ResponseEntity<HttpStatus> createAccount(@RequestBody Account account) {
         accountService.createAccount(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<HttpStatus> updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
    }

}
