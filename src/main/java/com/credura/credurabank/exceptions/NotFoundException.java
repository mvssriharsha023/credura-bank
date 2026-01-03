package com.credura.credurabank.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String error) { super(error); }
}
