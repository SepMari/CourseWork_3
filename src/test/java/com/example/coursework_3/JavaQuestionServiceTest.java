package com.example.coursework_3;

import com.example.coursework_3.domain.Question;
import com.example.coursework_3.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;
    private static final Question QUESTION1 = new Question("test1", "test1");
    private static final Question QUESTION2 = new Question("test2", "test2");
    private static final Question QUESTION3 = new Question("test3", "test3");
    private static final Question QUESTION4 = new Question("test4", "test4");

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add(QUESTION1);
        javaQuestionService.add(QUESTION2);
        javaQuestionService.add(QUESTION3);
        javaQuestionService.add(QUESTION4);
    }

    @Test
    void add() {
        javaQuestionService.addQuestion("test1", "test1");
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION3);
        excepted.add(QUESTION4);
        assertEquals(javaQuestionService.allQuestion(), excepted);
    }

    @Test
    void addObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION3);
        excepted.add(QUESTION4);
        javaQuestionService.add(QUESTION1);
        assertEquals(javaQuestionService.allQuestion(), excepted);
    }

    @Test
    void testAddSameObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION3);
        excepted.add(QUESTION4);
        javaQuestionService.add(QUESTION1);
        assertEquals(javaQuestionService.allQuestion(), excepted);

    }

    @Test
    void remove() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION3);
        excepted.add(QUESTION4);
        javaQuestionService.removeQuestion(QUESTION2);
        assertEquals(javaQuestionService.allQuestion(), excepted);
    }

    @Test
    void removeNonExistedObject() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION2);
        excepted.add(QUESTION3);
        excepted.add(QUESTION4);
        javaQuestionService.removeQuestion(QUESTION1);
        assertEquals(javaQuestionService.allQuestion(), excepted);
    }

    @Test
    void getAll() {
        Set<Question> excepted = new HashSet<>();
        excepted.add(QUESTION1);
        excepted.add(QUESTION2);
        excepted.add(QUESTION3);
        excepted.add(QUESTION4);
        assertEquals(javaQuestionService.allQuestion(), excepted);
    }

    @Test
    void getAllEmptySet() {
        Set<Question> excepted = new HashSet<>();
        javaQuestionService.removeQuestion(QUESTION1);
        javaQuestionService.removeQuestion(QUESTION2);
        javaQuestionService.removeQuestion(QUESTION3);
        javaQuestionService.removeQuestion(QUESTION4);
        assertEquals(javaQuestionService.allQuestion(), excepted);
    }

    @Test
    void getRandomQuestion() {
        Question temp = javaQuestionService.getRandomQuestion();
        assertTrue(temp.equals(QUESTION1) || temp.equals(QUESTION2) || temp.equals(QUESTION3)  || temp.equals(QUESTION4));
    }

    @Test
    void getRandomQuestionEmptySet() {
        javaQuestionService.removeQuestion(QUESTION1);
        javaQuestionService.removeQuestion(QUESTION2);
        javaQuestionService.removeQuestion(QUESTION3);
        javaQuestionService.removeQuestion(QUESTION4);
        assertThrows(ResponseStatusException.class, () -> javaQuestionService.getRandomQuestion());
    }

    @Test
    void getSize() {
        assertEquals(4, javaQuestionService.getSize());
    }

}
