package com.cot.bankingappspringboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<MessageError> EmptyResultDataAccessExceptionHandler(Exception exception) {
        logger.error(exception.getMessage());
        return new ResponseEntity<>(new MessageError(exception.getMessage()),HttpStatus.NO_CONTENT);
    }


}
