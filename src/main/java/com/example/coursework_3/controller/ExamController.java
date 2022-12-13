package com.example.coursework_3.controller;

import com.example.coursework_3.domain.Question;
import com.example.coursework_3.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/get/random/{amount}")
    Collection<Question> getQuestions(@PathVariable int amount){
        return this.service.getQuestions(amount);
        //ответ в виде списка случайных вопросов-ответов, количество которых равно amount
    }
}
