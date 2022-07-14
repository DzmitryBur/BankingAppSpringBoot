package com.cot.bankingappspringboot.service;

import com.cot.bankingappspringboot.repository.BankRepository;
import com.cot.bankingappspringboot.mapper.BankMapper;
import com.cot.bankingappspringboot.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements BankRepository {

    private JdbcTemplate jdbcTemplate;
    private BankMapper bankMapper;

    @Autowired
    public BankService(JdbcTemplate jdbcTemplate, BankMapper bankMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.bankMapper = bankMapper;
    }

    @Override
    public List<Bank> getAllBanks() {
        return jdbcTemplate.query("SELECT * FROM banks", bankMapper);
    }

    @Override
    public Bank getBank(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM banks WHERE id=?", bankMapper, id);
    }

    @Override
    public int createBank(Bank bank) {
        return jdbcTemplate.update("INSERT INTO banks (id, name, swift) VALUES (DEFAULT,?,?)", bank.getName(), bank.getSwift());
    }

    @Override
    public void updateBank(Bank bank) {
        jdbcTemplate.update("UPDATE banks SET name = ?, swift =? WHERE id = ?", bank.getName(), bank.getSwift(), bank.getId());
    }

    @Override
    public void deleteBank(long id) {
        jdbcTemplate.update("DELETE FROM banks WHERE id=?", id);
    }
}

