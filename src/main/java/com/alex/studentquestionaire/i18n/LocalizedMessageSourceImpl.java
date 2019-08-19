package com.alex.studentquestionaire.i18n;

import com.alex.studentquestionaire.config.ApplicationConfigProperties;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class LocalizedMessageSourceImpl extends ResourceBundleMessageSource implements LocalizedMessageSource{

    private List<String> supportedLocales;

    @Autowired
    public LocalizedMessageSourceImpl(@NonNull final ApplicationConfigProperties config) {
        this.setDefaultEncoding("UTF-8");
        this.setBasenames(config.getMessageSource());
        this.supportedLocales = config.getSupportedLocales();
    }

    @Override
    public String getMessageFor(String key) {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();

        boolean isSupportedLocale = supportedLocales.contains(language);
        if (!isSupportedLocale) {
            throw new RuntimeException("Unrecognized locale");
        }
        return getMessage(key, null, locale);
    }
}
