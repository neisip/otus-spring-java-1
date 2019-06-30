package com.alex.studentquestionaire.service;

import lombok.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class ConsoleServiceImpl implements ConsoleService {

    @NonNull private final PrintStream out;
    @NonNull private final Scanner scanner;

    public ConsoleServiceImpl(@NonNull final PrintStream output,
                              @NonNull final Scanner scanner) {
        this.out = output;
        this.scanner = scanner;
    }

    public void println(@NonNull final String message) {
        out.println(message);
    }

    @Nullable
    public String readLine() {
        return scanner.nextLine();
    }

}
