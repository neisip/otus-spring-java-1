package com.alex.studentquestionaire.config;

import com.alex.studentquestionaire.domain.ConsoleContext;
import com.alex.studentquestionaire.i18n.LocalizedMessageSource;
import com.alex.studentquestionaire.i18n.LocalizedMessageSourceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Scanner;

@PropertySource("classpath:application.properties")
@Configuration
public class QuestionaireConfig {

    @Bean
    @NonNull
    ConsoleContext context() {
        return new ConsoleContext(System.out, new Scanner(System.in));
    }


    @Bean
    public LocalizedMessageSource messageSource(@Value("${resource.messages}") String baseName){
        final LocalizedMessageSourceImpl messageSource = new LocalizedMessageSourceImpl();
        messageSource.setBasenames(baseName);
        return messageSource;
    }
}
