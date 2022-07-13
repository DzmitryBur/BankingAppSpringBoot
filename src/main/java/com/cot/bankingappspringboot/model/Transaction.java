package com.cot.bankingappspringboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Data
public class Transaction {

    private long id;
    private long amount;
    private Timestamp date;
    private long id_accounts;

}


