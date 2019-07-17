package com.alex.studentquestionaire.i18n;

import org.springframework.context.MessageSource;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public interface LocalizedMessageSource extends MessageSource {
    @Nullable String getMessageFor(@NonNull String key);
}
