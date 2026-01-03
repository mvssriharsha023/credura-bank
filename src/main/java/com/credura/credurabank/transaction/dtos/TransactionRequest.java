package com.credura.credurabank.transaction.dtos;

import com.credura.credurabank.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequest {

    private TransactionType transactionType;

    private BigDecimal amount;

    private String description;

    private String accountNumber;

    private String destinationAccountNumber; // the receiving account number if it's a transfer
}
