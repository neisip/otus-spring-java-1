package com.alex.studentquestionaire.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;


@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final @NonNull QuizService quizService;
    private final @NonNull QuizResultOutputService outputService;

    public QuestionnaireServiceImpl(@NonNull QuizService quizService,
                                    @NonNull QuizResultOutputService outputService) {

        this.quizService = quizService;
        this.outputService = outputService;
    }

    public void askQuestions() {
        quizService.askName();
        quizService.askFamilyName();
        quizService.askQuizQuestions();
        outputService.outputReport(quizService.buildReport());
    }
}
