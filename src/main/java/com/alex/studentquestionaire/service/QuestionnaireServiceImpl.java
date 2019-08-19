package com.alex.studentquestionaire.service;

import lombok.NonNull;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

@ShellComponent
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private final @NonNull QuizService quizService;
    private final @NonNull QuizResultOutputService outputService;

    public QuestionnaireServiceImpl(@NonNull QuizService quizService,
                                    @NonNull QuizResultOutputService outputService) {

        this.quizService = quizService;
        this.outputService = outputService;
    }


    @ShellMethod(value = "Ask name", key = {"n", "name"})
    public void askName() {
        quizService.askName();
    }


    @ShellMethod(value = "Ask  family name", key = {"fn", "familyName"})
    public void askFamilyName() {
        quizService.askFamilyName();
    }

    @ShellMethod(value = "Ask  questions", key = {"q", "questions"})
    public void askQuestions() {
        quizService.askQuizQuestions();

    }

    @ShellMethod(value = "Report", key = {"r", "report"})
    public void outputResult() {
        outputService.outputReport(quizService.buildReport());
    }
}
