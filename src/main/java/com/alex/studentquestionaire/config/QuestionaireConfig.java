package com.alex.studentquestionaire.config;

import com.alex.studentquestionaire.dao.QuizDAO;
import com.alex.studentquestionaire.dao.QuizDAOImpl;
import com.alex.studentquestionaire.domain.ConsoleContext;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

import java.util.Scanner;

@Configuration
public class QuestionaireConfig {

    @Bean
    @NonNull
    public ConsoleContext context() {
        return new ConsoleContext(System.out, new Scanner(System.in));
    }

    @Bean
    @NonNull
    @ConfigurationProperties
    ApplicationConfigProperties configProperties() {
        return new ApplicationConfigProperties();
    }

    @Bean
    @NonNull
    public QuizDAO quizDAO() {
        String csvFullPath = configProperties().getCsvName() + localePath;
        return new QuizDAOImpl(csvFullPath);
    }

    @Value("_#{systemProperties['user.language']}.csv")
    private String localePath;

}
