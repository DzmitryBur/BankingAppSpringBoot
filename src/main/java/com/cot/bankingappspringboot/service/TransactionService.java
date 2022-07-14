package com.cot.bankingappspringboot.service;

import com.cot.bankingappspringboot.mapper.TransactionMapper;
import com.cot.bankingappspringboot.model.Transaction;
import com.cot.bankingappspringboot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements TransactionRepository {

    private JdbcTemplate jdbcTemplate;
    private TransactionMapper transactionMapper;

    @Autowired
    public TransactionService(JdbcTemplate jdbcTemplate, TransactionMapper transactionMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return jdbcTemplate.query("SELECT * FROM transactions", transactionMapper);
    }

    @Override
    public Transaction getTransaction(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM transactions WHERE id=?", transactionMapper, id);
    }

    @Override
    public int createTransaction(Transaction transaction) {
        return jdbcTemplate.update("INSERT INTO transactions(id, amount, date, id_accounts) VALUES (DEFAULT,?,?,?)", transaction.getAmount(), transaction.getDate(), transaction.getId_accounts());
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        jdbcTemplate.update("UPDATE transactions SET date = ?, amount =?, id_accounts =? WHERE id = ?", transaction.getDate(),transaction.getAmount(), transaction.getId_accounts(), transaction.getId());
    }

    @Override
    public void deleteTransaction(long id) {
        jdbcTemplate.update("DELETE FROM transactions WHERE id=?", id);
    }
}



