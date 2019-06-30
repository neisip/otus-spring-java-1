package com.alex.studentquestionaire;

import com.alex.studentquestionaire.dao.QuizDAO;
import com.alex.studentquestionaire.domain.Answer;
import com.alex.studentquestionaire.domain.Question;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class QuizServiceTest {

    private ConsoleService cs;
    private QuizDAO qd;
    private QuizService sut;

    @Before
    public void setUp() {
        cs = mock(ConsoleService.class);
        qd = mock(QuizDAO.class);
        sut = new QuizServiceImpl(qd, cs);

    }

    @Test
    public void itAsksName() {
        val name = "A";
        when(cs.readLine()).thenReturn(name);
        sut.askName();
        verify(cs).readLine();
        verify(cs).println("Please Enter your Name in proper format:");
    }

    @Test
    public void itAsksFamilyName() {
        val familyName = "B";
        when(cs.readLine()).thenReturn(familyName);
        sut.askFamilyName();
        verify(cs).readLine();
        verify(cs).println("Please Enter your Family name in proper format:");
    }

    @Test
    public void itAsksQuizQuestions() {

        val q = "foo";
        val a = "bar";
        List<Map.Entry<Question, Answer>> mockQuiz = new ArrayList<>();
        val entry = new AbstractMap.SimpleEntry<>(new Question(q), new Answer(a));
        mockQuiz.add(entry);

        when(qd.getQuiz()).thenReturn(mockQuiz);
        when(cs.readLine()).thenReturn(a);

        sut.askQuizQuestions();

        verify(cs).println(q);
        verify(cs).println(QuizServiceImpl.Result.SUCCESS.toString());
    }


}
