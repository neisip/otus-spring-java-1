package com.alex.studentquestionaire;

import com.alex.studentquestionaire.controller.QuestionnaireController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StudentQuestionnaireApplication {

	public static void main(String[] args) { SpringApplication.run(StudentQuestionnaireApplication.class, args); }
//
	@Autowired
	private QuestionnaireController service;
//
//	@Value("${start}")
//	private boolean shouldStart;
//
//	@PostConstruct
//	private void runQuiz() {
//		if (shouldStart) {
//			service.askQuestions();
//		}
//	}
//

}
