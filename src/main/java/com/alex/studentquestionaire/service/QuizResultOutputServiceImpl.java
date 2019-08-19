package com.alex.studentquestionaire.service;

import com.alex.studentquestionaire.entity.QuizReport;
import com.alex.studentquestionaire.i18n.LocalizedMessageSource;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class QuizResultOutputServiceImpl implements QuizResultOutputService {
    public final static @NonNull String RESULT = "result";

    private final @NonNull ConsoleService consoleService;
    private final @NonNull LocalizedMessageSource messageSource;

    public QuizResultOutputServiceImpl(@NonNull ConsoleService consoleService,
                                       @NonNull LocalizedMessageSource messageSource) {

        this.consoleService = consoleService;
        this.messageSource = messageSource;
    }

    @Override
    public void outputReport(QuizReport report) {
        consoleService.println(report.getName() +
                " " +
                report.getFamilyName() + " " +
                messageSource.getMessageFor(RESULT) +
                report.getSuccessAnswersCount() +
                "/" + report.getQuestionCount());
    }
}

