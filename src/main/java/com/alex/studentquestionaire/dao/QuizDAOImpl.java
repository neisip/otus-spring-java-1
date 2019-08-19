package com.alex.studentquestionaire.dao;

import com.alex.studentquestionaire.config.ApplicationConfigProperties;
import com.alex.studentquestionaire.domain.Answer;
import com.alex.studentquestionaire.domain.Question;
import com.alex.studentquestionaire.exceptions.CSVInconsistencyException;
import com.alex.studentquestionaire.utils.CSVReader;
import lombok.NonNull;
import lombok.val;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizDAOImpl implements QuizDAO {

    private final @NonNull List<Map.Entry<Question, Answer>> quiz;

    public QuizDAOImpl(@NonNull final String fullPath)  {
        this.quiz = readQuizFromCSV(fullPath);
    }

    private @NonNull List<Map.Entry<Question, Answer>> readQuizFromCSV(@NonNull final String csvName)   {
        val elements = new CSVReader().loadObjectList(String.class, csvName);
        int count = elements.size();

        if (count % 2 == 1) {
            throw new CSVInconsistencyException("Warning data doesn't conform to quiz demands");
        }

        var e = new ArrayList<Map.Entry<Question, Answer>>();
        for(int i = 0; i < count; i = i + 2) {
            val question = new Question(elements.get(i));
            val answer = new Answer(elements.get(i + 1));
            e.add(new SimpleEntry<>(question,answer));
        }
        return e;
    }

    @Override
    public @NonNull List<Map.Entry<Question, Answer>> getQuiz() {
        return quiz;
    }
}
