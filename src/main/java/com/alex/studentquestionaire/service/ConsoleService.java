package com.alex.studentquestionaire.service;

import lombok.NonNull;
import org.springframework.lang.Nullable;

public interface ConsoleService {
    void println(@NonNull String output);
    @Nullable String readLine();
}
