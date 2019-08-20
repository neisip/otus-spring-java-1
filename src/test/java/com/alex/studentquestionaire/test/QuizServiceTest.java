package com.alex.studentquestionaire.test;

import com.alex.studentquestionaire.domain.Answer;
import com.alex.studentquestionaire.domain.Question;
import com.alex.studentquestionaire.i18n.LocalizedMessageSource;
import com.alex.studentquestionaire.dao.QuizDAO;
import com.alex.studentquestionaire.service.ConsoleService;
import com.alex.studentquestionaire.service.QuizService;
import com.alex.studentquestionaire.service.QuizServiceImpl;
import org.junit.Test;
import lombok.val;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class QuizServiceTest {

    @Configuration
    static class InnerConfig {
        @Bean
        QuizService makeSut() {
            return new QuizServiceImpl(quizDAO, consoleService, messageSource);
        }
        @MockBean
        private ConsoleService consoleService;

        @MockBean
        private QuizDAO quizDAO;

        @MockBean
        private LocalizedMessageSource messageSource;
    }

    @Autowired
    private ConsoleService consoleService;

    @Autowired
    private QuizDAO quizDAO;

    @Autowired
    private LocalizedMessageSource messageSource;

    @Autowired
    private QuizService sut;

    @Test
    public void itAsksName() {

        when(messageSource.getMessageFor(QuizServiceImpl.GREETING_NAME)).thenReturn("N");

        val name = "A";
        when(consoleService.readLine()).thenReturn(name);
        sut.askName();
        verify(consoleService).readLine();
        verify(consoleService).println("N");
    }

    @Test
    public void itAsksFamilyName() {
        when(messageSource.getMessageFor(QuizServiceImpl.GREETING_FAMILY_NAME)).thenReturn("FN");

        val familyName = "B";
        when(consoleService.readLine()).thenReturn(familyName);
        sut.askFamilyName();
        verify(consoleService).readLine();
        verify(consoleService).println("FN");
    }

    @Test
    public void itAsksQuizQuestions() {

        val q = "foo";
        val a = "bar";
        List<Map.Entry<Question, Answer>> mockQuiz = new ArrayList<>();
        val entry = new AbstractMap.SimpleEntry<>(new Question(q), new Answer(a));
        mockQuiz.add(entry);

        when(messageSource.getMessageFor(QuizServiceImpl.ANSWER_SUCCESS)).thenReturn("N");
        when(quizDAO.getQuiz()).thenReturn(mockQuiz);
        when(consoleService.readLine()).thenReturn(a);

        sut.askQuizQuestions();

        verify(consoleService).println(q);
        verify(consoleService).println("N");
    }


}
