package com.alex.studentquestionaire;

import com.alex.studentquestionaire.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StudentQuestionnaireApplication {

	public static void main(String[] args) { SpringApplication.run(StudentQuestionnaireApplication.class, args); }

	@Autowired
	private QuestionnaireService service;

	@PostConstruct
	private void runQuiz() {
		service.askQuestions();
	}


}
