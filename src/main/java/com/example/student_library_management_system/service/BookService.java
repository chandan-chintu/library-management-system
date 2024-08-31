package com.example.student_library_management_system.service;

import com.example.student_library_management_system.dto.AuthorRequestDto;
import com.example.student_library_management_system.dto.BookRequestDto;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.repository.AuthorRepository;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.student_library_management_system.converters.BookConverter.convertBookRequestDtoToBook;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String createBook(BookRequestDto bookRequestDto){
        Book book = new Book();
        book = convertBookRequestDtoToBook(bookRequestDto);

        // first get the car details from cardId
        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
        book.setCard(card);

        // next we need get the author deatils from authorId
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        bookRepository.save(book);
        return "Book saved successfully";
    }

    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public Book getBookById(int bookId){
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Book book = bookOptional.get();
        return book;
    }
}
