package com.cot.bankingappspringboot.controller;

import com.cot.bankingappspringboot.model.Bank;
import com.cot.bankingappspringboot.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping
    public ResponseEntity<List<Bank>> getAllBanks() {
        List<Bank> list = bankService.getAllBanks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    Bank getBank(@PathVariable long id){

        return bankService.getBank(id);
    }

    @PostMapping
    ResponseEntity<HttpStatus> createBank(@RequestBody Bank bank) {
        bankService.createBank(bank);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<HttpStatus> updateBank(@RequestBody Bank bank) {
        bankService.updateBank(bank);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteBank(@PathVariable long id) {
        bankService.deleteBank(id);
    }

}
