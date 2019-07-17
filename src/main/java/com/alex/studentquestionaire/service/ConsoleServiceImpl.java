package com.alex.studentquestionaire.service;

import com.alex.studentquestionaire.domain.ConsoleContext;
import lombok.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;


@Service
public class ConsoleServiceImpl implements ConsoleService {

    @NonNull
    private final ConsoleContext context;

    public ConsoleServiceImpl(@NonNull final ConsoleContext context) {
        this.context = context;
    }

    public void println(@NonNull final String message) {
        context.getOutput().println(message);
    }

    @Nullable
    public String readLine() {
        return context.getInput().nextLine();
    }

}
