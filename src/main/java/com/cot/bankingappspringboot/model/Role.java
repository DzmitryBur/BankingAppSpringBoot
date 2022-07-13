package com.cot.bankingappspringboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Role {

    long id;
    String role;

}
