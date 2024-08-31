package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.dto.TransactionRequestDto;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/create")
    public String addTransaction(@RequestBody TransactionRequestDto transactionRequestDto) {
        return transactionService.createTransaction(transactionRequestDto);
    }

    @GetMapping("/findAll")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/find/{transactionid}")
    public Transaction getTransactionById(@PathVariable("transactionid") int transactionId){
        return transactionService.getTransactionById(transactionId);
    }
}
