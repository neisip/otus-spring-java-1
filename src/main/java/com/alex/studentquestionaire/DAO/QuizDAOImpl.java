package com.alex.studentquestionaire.DAO;

import com.alex.studentquestionaire.Domain.Answer;
import com.alex.studentquestionaire.Domain.Question;
import com.alex.studentquestionaire.Utils.CSVReader;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuizDAOImpl implements QuizDAO {

    private List<Map.Entry<Question, Answer>> quiz;

    public QuizDAOImpl(String csvName) {
        this.quiz = readQuizFromCSV(csvName);
    }

    private List<Map.Entry<Question, Answer>> readQuizFromCSV(String csvName) {
        val elements = new CSVReader().loadObjectList(String.class, csvName);
        int count = elements.size();

        if (count % 2 == 1) {
            throw new RuntimeException(); // Too lazy to handle it.
        }

        var e = new ArrayList<Map.Entry<Question, Answer>>();
        for(int i = 0; i < count; i = i + 2) {
            val question = new Question(elements.get(i));
            val answer = new Answer(elements.get(i + 1));
            val entry = new SimpleEntry(question,answer);
            e.add(entry);
        }
        return e;
    }

    @Override
    public List<Map.Entry<Question, Answer>> getQuiz() {
        return quiz;
    }
}
