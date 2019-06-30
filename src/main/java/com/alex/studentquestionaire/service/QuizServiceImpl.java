package com.alex.studentquestionaire.service;

import com.alex.studentquestionaire.dao.QuizDAO;
import com.alex.studentquestionaire.entity.QuizReport;
import lombok.NonNull;
import lombok.val;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    public enum Result {
        SUCCESS("Y're right!"),
        FAILURE("Damn shame !");

        private final @NonNull String text;

        Result(final @NonNull String text) {
            this.text = text;
        }

        @Override
        public @NonNull String toString() {
            return text;
        }
    }

    private @Nullable String name;
    private @Nullable String familyName;
    private @Nullable Integer successCount;
    private @Nullable Integer quizSize;

    @NonNull
    private final ConsoleService consoleService;

    @NonNull
    private final QuizDAO dao;

    public QuizServiceImpl(@NonNull QuizDAO dao, @NonNull ConsoleService consoleService) {
        this.dao = dao;
        this.consoleService = consoleService;
    }

    @Override
    public void askName() {
        var name = "";
        while (name.isBlank()) {
            consoleService.println("Please Enter your Name in proper format:");
            name = consoleService.readLine();
        }
        this.name = name;
    }

    @Override
    public void askFamilyName() {
        var familyName = "";
        while (familyName.isBlank()) {
            consoleService.println("Please Enter your Family name in proper format:");
            familyName = consoleService.readLine();
        }
        this.familyName = familyName;
    }

    @Override
    public void askQuizQuestions() {
        int successCount = 0;
        val quiz = dao.getQuiz();

        for (val e: quiz) {
            val q = e.getKey().getMsg();
            consoleService.println(q);
            String o = consoleService.readLine();

            val a = e.getValue().getMsg();
            if (o.equals(a)) {
                consoleService.println(Result.SUCCESS.toString());
                successCount++;
            } else {
                consoleService.println(Result.FAILURE.toString());
                consoleService.println(a);
            }
        }
        this.quizSize = quiz.size();
        this.successCount = successCount;
    }

    @Override
    public QuizReport buildReport() {
        return new QuizReport(name, familyName, quizSize,successCount);
    }
}
