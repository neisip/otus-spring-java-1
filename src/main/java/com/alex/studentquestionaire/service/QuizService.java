package com.alex.studentquestionaire.service;

import com.alex.studentquestionaire.entity.QuizReport;

public interface QuizService {
    void askName();
    void askFamilyName();
    void askQuizQuestions();
    QuizReport buildReport();
}
