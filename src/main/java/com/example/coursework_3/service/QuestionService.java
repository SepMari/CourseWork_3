package com.example.coursework_3.service;

import com.example.coursework_3.domain.Question;

import java.util.Collection;

public interface QuestionService {
    //добавить вопрос
    Question addQuestion(String question, String answer);

    //еще раз добавить, но уже в хранилище
    Question add(Question question);

    //удалить вопрос из хранилища
    Question removeQuestion(Question question);

    //получить все вопросы
    Collection<Question> allQuestion();

    //получить рандомно вопросы
    Question getRandomQuestion();

    //получить длину для рандома
    int getSize();
}
