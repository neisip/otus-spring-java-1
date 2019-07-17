package com.alex.studentquestionaire.dao;

import com.alex.studentquestionaire.domain.Answer;
import com.alex.studentquestionaire.domain.Question;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

public interface QuizDAO {
    @NonNull List<Map.Entry<Question, Answer>> getQuiz();
}
