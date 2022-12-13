package com.example.coursework_3.controller;

import com.example.coursework_3.domain.Question;
import com.example.coursework_3.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("")
    public Collection<Question> allQuestion(){
        return this.service.allQuestion();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("Question") String question, @RequestParam("Answer") String answer){
        return this.service.addQuestion(question, answer);
    }

    @GetMapping ("/remove")
    public Question removeQuestion(@RequestParam("Question") String question, @RequestParam("Answer") String answer) {
        return this.service.removeQuestion(new Question(question, answer));
    }
}
