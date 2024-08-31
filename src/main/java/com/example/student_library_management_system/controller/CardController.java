package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.model.Transaction;
import com.example.student_library_management_system.service.CardService;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/findAll")
    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }

    @GetMapping("/find/{cardid}")
    public Card getCardById(@PathVariable("cardid") int cardId){
        return cardService.getCardById(cardId);
    }
}
