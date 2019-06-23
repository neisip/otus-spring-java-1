package com.alex.studentquestionaire.Domain;
import lombok.NonNull;
import lombok.Value;

@Value
public class Answer {
    @NonNull
    String msg;
}
