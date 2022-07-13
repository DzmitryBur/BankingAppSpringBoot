package com.cot.bankingappspringboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Bank {

    private long id;
    private String name;
    private String swift;

}
