package com.credura.credurabank.exceptions;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String error) { super(error); }
}
