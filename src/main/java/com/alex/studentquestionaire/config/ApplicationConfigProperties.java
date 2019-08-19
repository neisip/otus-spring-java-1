package com.alex.studentquestionaire.config;
import org.springframework.lang.NonNull;

import java.util.List;


public class ApplicationConfigProperties {

    @NonNull
    private String csvName;

    @NonNull
    private String messageSource;

    @NonNull
    private List<String> supportedLocales;

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

    public List<String> getSupportedLocales() {
        return supportedLocales;
    }

    public void setSupportedLocales(List<String> supportedLocales) {
        this.supportedLocales = supportedLocales;
    }

}
