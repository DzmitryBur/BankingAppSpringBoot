package com.cot.bankingappspringboot.exception;

public class MessageError {

    String message;

    public MessageError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
