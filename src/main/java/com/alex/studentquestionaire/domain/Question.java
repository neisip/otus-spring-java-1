package com.alex.studentquestionaire.domain;
import lombok.NonNull;
import lombok.Value;

public @Value
class Question {
    @NonNull String msg;
}
