package com.cot.bankingappspringboot.repository;

import com.cot.bankingappspringboot.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository {

    List<Transaction> getAllTransactions();

    Transaction getTransaction(long id);

    int createTransaction(Transaction transaction);

    void updateTransaction(Transaction transaction);

    void deleteTransaction(long id);
}
