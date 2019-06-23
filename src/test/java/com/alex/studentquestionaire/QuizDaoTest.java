package com.alex.studentquestionaire;

import com.alex.studentquestionaire.DAO.QuizDAO;
import com.alex.studentquestionaire.DAO.QuizDAOImpl;
import org.junit.Assert;
import org.junit.Test;
import lombok.val;

public class QuizDaoTest {
    private final QuizDAO sut = new QuizDAOImpl("Mock/MockDumbQuestions.csv");

    @Test
    public void itReturnsProperQuiz() {
        //given
        //when
        val e = sut.getQuiz();

        //then
        val first = e.get(0);

       Assert.assertEquals("Buzz?" ,first.getKey().getMsg());
       Assert.assertEquals("Feed" ,first.getValue().getMsg());
    }

}
