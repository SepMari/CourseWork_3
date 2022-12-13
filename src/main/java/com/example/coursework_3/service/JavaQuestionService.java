package com.example.coursework_3.service;

import com.example.coursework_3.domain.Question;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question addQuestion(String question, String answer) {
        validateInput(question);
        validateInput(answer);

        Question q = new Question(question, answer);
        questions.add(q);

        return q;
    }

    @Override
    public Question add(Question question) {
        validateQuestion(question);
        questions.add(question);

        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        validateQuestion(question);
        questions.remove(question);

        return question;
    }

    @Override
    public Collection<Question> allQuestion() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        Random random = new Random();
        Object[] temp = questions.toArray();

        return (Question) temp[random.nextInt(temp.length)];

        //с помощью класса Random и его метода nextInt,
        // который в качестве параметра принимает максимальное число,
        // а затем возвращает вам результат
        // в виде случайного числа от 0 до максимального числа из параметров (не включительно)
    }

    @Override
    public int getSize() {
        return questions.size();
    }

    private void validateQuestion(Question question) {
        if (question == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    private void validateInput(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
