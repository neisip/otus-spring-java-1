package com.alex.studentquestionaire.service;

import com.alex.studentquestionaire.dao.QuizDAO;
import com.alex.studentquestionaire.entity.QuizReport;
import com.alex.studentquestionaire.i18n.LocalizedMessageSource;
import lombok.NonNull;
import lombok.val;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class QuizServiceImpl implements QuizService {
    public final static @NonNull String GREETING_NAME = "greeting.name";
    public final static @NonNull String GREETING_FAMILY_NAME = "greeting.familyName";
    public final static @NonNull String ANSWER_SUCCESS = "answer.success";
    public final static @NonNull String ANSWER_FAILURE = "answer.failure";
    private @Nullable String name;
    private @Nullable String familyName;
    private @Nullable Integer successCount;
    private @Nullable Integer quizSize;


    @NonNull
    private final ConsoleService consoleService;

    @NonNull
    private final QuizDAO dao;

    @NonNull
    private final LocalizedMessageSource messageSource;

    public QuizServiceImpl(@NonNull QuizDAO dao,
                           @NonNull ConsoleService consoleService,
                           @NonNull LocalizedMessageSource messageSource) {
        this.dao = dao;
        this.consoleService = consoleService;
        this.messageSource = messageSource;
    }

    @Override

    public void askName() {
        var name = "";
        while (name.isBlank()) {
            final String message = messageSource.getMessageFor(GREETING_NAME);
            consoleService.println(message);
            name = consoleService.readLine();
        }
        this.name = name;
    }

    @Override
    public void askFamilyName() {
        var familyName = "";
        while (familyName.isBlank()) {
            final String message = messageSource.getMessageFor(GREETING_FAMILY_NAME);
            consoleService.println(message);
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
            final String o = consoleService.readLine();

            val a = e.getValue().getMsg();

            if (o.equals(a)) {
                consoleService.println(messageSource.getMessageFor(ANSWER_SUCCESS));
                successCount++;
            } else {
                consoleService.println(messageSource.getMessageFor(ANSWER_FAILURE));
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
