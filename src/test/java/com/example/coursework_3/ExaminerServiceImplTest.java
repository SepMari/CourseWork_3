package com.example.coursework_3;

import com.example.coursework_3.domain.Question;
import com.example.coursework_3.service.ExaminerServiceImpl;
import com.example.coursework_3.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private static final Question QUESTION = new Question("Question", "Answer");

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService questionService;

    @BeforeEach
    void setUp() {
        when(questionService.getSize()).thenReturn(5);
    }

    @Test
    void getQuestions() {
        when(questionService.getRandomQuestion()).thenReturn(QUESTION);
        Set<Question> excepted = Set.of(QUESTION);
        assertEquals(excepted, examinerService.getQuestions(1));
    }

    @Test
    void getQuestionsExtend() {
        assertThrows(ResponseStatusException.class, () -> examinerService.getQuestions(7));
    }

}
