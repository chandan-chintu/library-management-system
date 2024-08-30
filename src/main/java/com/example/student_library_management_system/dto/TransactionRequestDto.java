package com.example.student_library_management_system.dto;

import com.example.student_library_management_system.enums.TransactionStatus;
import lombok.Data;

@Data
public class TransactionRequestDto {

    private TransactionStatus transactionStatus;

    private double fine;

    private boolean issueOperation;

    private int cardId;

    private int bookId;
}
