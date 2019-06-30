package com.alex.studentquestionaire.config;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@PropertySource("classpath:application.properties")
@Configuration
public class QuestionaireConfig {

    @Bean
    @NonNull
    PrintStream output() { return System.out; }

    @Bean
    @NonNull
    Scanner input() { return new Scanner(System.in); }
}
