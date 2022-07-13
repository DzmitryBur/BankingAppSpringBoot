package com.cot.bankingappspringboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {

    private long id;
    private String name;
    private String industry;
    private String residency;
    private String login;
    private String password;

}