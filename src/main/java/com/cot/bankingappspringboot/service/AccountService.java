package com.cot.bankingappspringboot.service;

import com.cot.bankingappspringboot.mapper.AccountMapper;
import com.cot.bankingappspringboot.model.Account;
import com.cot.bankingappspringboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements AccountRepository {

    private JdbcTemplate jdbcTemplate;
    private AccountMapper accountMapper;

    @Autowired
    public AccountService(JdbcTemplate jdbcTemplate, AccountMapper accountMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<Account> getAllAccounts() {
        return jdbcTemplate.query("SELECT * FROM accounts", accountMapper);
    }

    @Override
    public Account getAccount(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM accounts WHERE id=?", accountMapper, id);
    }

    @Override
    public int createAccount(Account account) {
        return jdbcTemplate.update("INSERT INTO accounts(id, iban, balance, banks_id, user_id) VALUES (DEFAULT,?,?,?,?)", account.getIban(), account.getBalance(), account.getBanks_id(), account.getUser_id());
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE accounts SET iban = ?, balance =?, banks_id =?, user_id =?  WHERE id = ?", account.getIban(), account.getBalance(), account.getBanks_id(), account.getUser_id(), account.getId());
    }


    @Override
    public void deleteAccount(long id) {
        jdbcTemplate.update("DELETE FROM accounts WHERE id=?", id);
    }
}


