package com.alex.studentquestionaire.Domain;
import lombok.NonNull;
import lombok.Value;

public @Value
class Question {
    @NonNull String msg;
}
