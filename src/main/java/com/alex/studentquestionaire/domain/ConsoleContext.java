package com.alex.studentquestionaire.domain;

import lombok.NonNull;
import lombok.Value;
import org.springframework.context.annotation.Bean;

import java.io.PrintStream;
import java.util.Scanner;

@Value
public class ConsoleContext {
    @NonNull PrintStream output;
    @NonNull Scanner input;
}
