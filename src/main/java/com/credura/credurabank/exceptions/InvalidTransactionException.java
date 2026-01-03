package com.credura.credurabank.exceptions;

public class InvalidTransactionException extends RuntimeException{
    public InvalidTransactionException(String error) { super(error); }
}
