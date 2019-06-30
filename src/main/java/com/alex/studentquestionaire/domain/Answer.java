package com.alex.studentquestionaire.domain;
import lombok.NonNull;
import lombok.Value;

@Value
public class Answer {
    @NonNull
    String msg;
}
