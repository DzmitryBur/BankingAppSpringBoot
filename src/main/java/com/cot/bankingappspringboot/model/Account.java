package com.cot.bankingappspringboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Account {

    private long id;
    private String iban;
    private long balance;
    private long banks_id;
    private long user_id;

}

