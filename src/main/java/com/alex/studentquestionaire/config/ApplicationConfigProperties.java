package com.alex.studentquestionaire.config;
import org.springframework.lang.NonNull;


public class ApplicationConfigProperties {

    @NonNull
    private String csvName;

    @NonNull
    private String messageSource;

    public String getCsvName() {
        return csvName;
    }

    public void setCsvName(String csvName) {
        this.csvName = csvName;
    }

    public String getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(String messageSource) {
        this.messageSource = messageSource;
    }
}
