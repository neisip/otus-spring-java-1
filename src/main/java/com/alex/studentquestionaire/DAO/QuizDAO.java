package com.alex.studentquestionaire.DAO;

import com.alex.studentquestionaire.Domain.Answer;
import com.alex.studentquestionaire.Domain.Question;
import java.util.List;
import java.util.Map;

public interface QuizDAO {
    List<Map.Entry<Question, Answer>> getQuiz();
}
