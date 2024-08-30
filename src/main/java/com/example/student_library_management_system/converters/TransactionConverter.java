package com.example.student_library_management_system.converters;

import com.example.student_library_management_system.dto.TransactionRequestDto;
import com.example.student_library_management_system.model.Transaction;

import java.util.UUID;

public class TransactionConverter {

    public static Transaction convertTransactionRequestDtoToTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = Transaction.builder().transactionStatus(transactionRequestDto.getTransactionStatus()).fine(transactionRequestDto.getFine())
                .transactionId(UUID.randomUUID().toString()).isIssueOperation(transactionRequestDto.isIssueOperation()).build();
        return transaction;
    }
}
