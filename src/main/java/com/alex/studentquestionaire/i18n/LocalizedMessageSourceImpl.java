package com.alex.studentquestionaire.i18n;

import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class LocalizedMessageSourceImpl extends ResourceBundleMessageSource implements LocalizedMessageSource{

    @Override
    public String getMessageFor(String key) {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();

        boolean isSupportedLocale = language.equals("ru") || language.equals("en");
        if (!isSupportedLocale) {
            throw new RuntimeException("Unrecognized locale");
        }
        return getMessage(key, null, locale);
    }
}
