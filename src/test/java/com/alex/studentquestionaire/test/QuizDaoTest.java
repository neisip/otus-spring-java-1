package com.alex.studentquestionaire.test;

import com.alex.studentquestionaire.dao.QuizDAO;
import com.alex.studentquestionaire.dao.QuizDAOImpl;
import com.alex.studentquestionaire.exceptions.CSVInconsistencyException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import lombok.val;
import org.springframework.lang.Nullable;

public class QuizDaoTest {
    private @Nullable
    QuizDAO sut;

    @Before
    public void setUp() {
        try {
            sut = new QuizDAOImpl("mock/MockDumbQuestions.csv");
        } catch (CSVInconsistencyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void itReturnsProperQuiz() {
        //given
        //when
        assert sut != null;
        val e = sut.getQuiz();

        //then
        val first = e.get(0);

       Assert.assertEquals("Buzz?" ,first.getKey().getMsg());
       Assert.assertEquals("Feed" ,first.getValue().getMsg());
    }

}
