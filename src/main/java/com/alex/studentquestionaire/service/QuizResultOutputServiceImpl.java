package com.alex.studentquestionaire.service;

import com.alex.studentquestionaire.entity.QuizReport;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class QuizResultOutputServiceImpl implements QuizResultOutputService {
    private final @NonNull ConsoleService consoleService;

    public QuizResultOutputServiceImpl(@NonNull ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void outputReport(QuizReport report) {
        consoleService.println(report.getName() +
                " " +
                report.getFamilyName() +
                " You've answered " +
                report.getSuccessAnswersCount() +
                "/" + report.getQuestionCount());
    }
}
