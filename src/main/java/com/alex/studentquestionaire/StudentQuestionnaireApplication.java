package com.alex.studentquestionaire;

import com.alex.studentquestionaire.Service.QuestionnaireService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentQuestionnaireApplication {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		QuestionnaireService s = (QuestionnaireService)context.getBean("questionnaireService");
		s.askQuestions();
	}
}
