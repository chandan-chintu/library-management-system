package com.example.student_library_management_system.service;

import com.example.student_library_management_system.dto.TransactionRequestDto;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import com.example.student_library_management_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.student_library_management_system.converters.TransactionConverter.convertTransactionRequestDtoToTransaction;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    public String createTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = new Transaction();
        transaction = convertTransactionRequestDtoToTransaction(transactionRequestDto);

        // get card details from cardId
        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        transaction.setCard(card);

        // get book details from bookId
        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setBook(book);

        transactionRepository.save(transaction);

        return "Transaction created";

    }

    public List<Transaction> getAllTransactions(){
        List<Transaction> transactionList = transactionRepository.findAll();
        return transactionList;
    }
}
