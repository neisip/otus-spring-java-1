package com.alex.studentquestionaire;

import com.alex.studentquestionaire.dao.QuizDAO;
import com.alex.studentquestionaire.domain.Answer;
import com.alex.studentquestionaire.domain.Question;
import com.alex.studentquestionaire.i18n.LocalizedMessageSource;
import com.alex.studentquestionaire.service.ConsoleService;
import com.alex.studentquestionaire.service.QuizService;
import com.alex.studentquestionaire.service.QuizServiceImpl;
import org.junit.Before;
import org.junit.Test;
import lombok.val;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class QuizServiceTest {

    private ConsoleService consoleService;
    private QuizDAO quizDAO;
    private QuizService sut;
    private LocalizedMessageSource messageSource = mock(LocalizedMessageSource.class);

    @Before
    public void setUp() {
        consoleService = mock(ConsoleService.class);
        quizDAO = mock(QuizDAO.class);
        sut = new QuizServiceImpl(quizDAO, consoleService, messageSource);
    }

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
