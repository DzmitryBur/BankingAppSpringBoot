package com.cot.bankingappspringboot.controller;

import com.cot.bankingappspringboot.model.Transaction;
import com.cot.bankingappspringboot.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> list = transactionService.getAllTransactions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    Transaction getTransaction(@PathVariable long id){

        return transactionService.getTransaction(id);
    }

   @PostMapping
    ResponseEntity<HttpStatus> createTransaction(@RequestBody Transaction transaction) {
       transactionService.createTransaction(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<HttpStatus> updateTransaction(@RequestBody Transaction transaction) {
        transactionService.updateTransaction(transaction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTransaction(@PathVariable long id) {
        transactionService.deleteTransaction(id);
    }

}
