package com.credura.credurabank.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String error) {
        super(error);
    }
}
