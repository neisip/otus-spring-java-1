package com.alex.studentquestionaire.i18n;

import com.alex.studentquestionaire.config.ApplicationConfigProperties;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocalizedMessageSourceImpl extends ResourceBundleMessageSource implements LocalizedMessageSource{

    @Autowired
    private Environment environment;

    @Autowired
    public LocalizedMessageSourceImpl(@NonNull final ApplicationConfigProperties config) {
        this.setBasenames(config.getMessageSource());
    }

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
