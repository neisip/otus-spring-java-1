package com.alex.studentquestionaire.service;

import lombok.NonNull;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class QuestionnaireControllerImpl implements QuestionnaireController {

    private final @NonNull QuizService quizService;
    private final @NonNull QuizResultOutputService outputService;

    private boolean hasAskedQuestions = false;

    public QuestionnaireControllerImpl(@NonNull QuizService quizService,
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
        hasAskedQuestions = true;

    }

    @ShellMethod(value = "Report", key = {"r", "report"})
    @ShellMethodAvailability("reportAvailabilityCheck")
    public void outputResult() {
        outputService.outputReport(quizService.buildReport());
    }

    public Availability reportAvailabilityCheck() {
        return hasAskedQuestions
                ? Availability.available()
                : Availability.unavailable("you didn't ask questions");
    }

}
