package com.techbank.techbank.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techbank.techbank.domain.transaction.*;

import java.math.BigDecimal;

public record TransactionDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long transactionId,
                             Long senderId,
                             Long receiverId,
                             BigDecimal value) {
    public TransactionDTO(Transaction transaction) {
        this(transaction.getTransactionId(), transaction.getSenderId(), transaction.getReceiverId(), transaction.getValue());
    }
}
