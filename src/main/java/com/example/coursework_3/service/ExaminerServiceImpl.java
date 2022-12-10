package com.example.coursework_3.service;

import com.example.coursework_3.domain.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount){
        if(amount > this.questionService.getSize()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Collection<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(this.questionService.getRandomQuestion());
        }
        return questions;
    }

    //Его задача: создать коллекцию и заполнить её
    // с помощью вызова getRandomQuestion у QuestionService случайными вопросами.

    //Если запрошено большее количество вопросов, чем хранится в сервисе, нужно выкинуть исключение.
    //Для этого, соответственно, нужно написать свое исключение со статусом BAD_REQUEST.
}
