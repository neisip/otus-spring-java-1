package com.alex.studentquestionaire.Service;

import com.alex.studentquestionaire.DAO.QuizDAO;
import com.alex.studentquestionaire.Domain.Question;
import lombok.NonNull;
import lombok.val;

import java.io.PrintStream;
import java.util.Scanner;

public class QuestionnaireServiceImpl implements QuestionnaireService {
    private enum Result {
        SUCCESS("Y're right!"),
        FAILURE("Damn shame !");

        private final String text;

        Result(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private QuizDAO dao;
    private String name;
    private String familyName;
    private Scanner scanner = new Scanner(System.in);

    //TOO lazy to pass behind interface and test properly
    private PrintStream out = System.out;

    QuestionnaireServiceImpl(@NonNull QuizDAO dao) {
        this.dao = dao;
    }

    public void askQuestions() {
        askName();
        askFamilyName();
        askQuizQuestions();
    }

    private void askName() {

        String name = "";
        while (name.isBlank()) {
            out.println("Please Enter your Name in proper format:");
            name = scanner.nextLine();
        }
        this.name = name;
    }

    private void askFamilyName() {

        String familyName = "";
        while (familyName.isBlank()) {
            out.println("Please Enter your Family name in proper format:");
            familyName = scanner.nextLine();
        }
        this.familyName = familyName;
    }

    private void askQuizQuestions() {
        int successCount = 0;
        val quiz = dao.getQuiz();

        for (val e: quiz) {
            val q = e.getKey().getMsg();
            out.println(q);
            String o = scanner.nextLine();

            val a = e.getValue().getMsg();
            if (o.equals(a)) {
                out.println(Result.SUCCESS.toString());
                successCount++;
            } else {
                out.println(Result.FAILURE.toString());
                out.println(a);
            }
        }
        out.println(name + " " + familyName + " You've answered " + successCount + "/" + quiz.size());
    }
}
