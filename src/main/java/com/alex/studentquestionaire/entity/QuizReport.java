package com.alex.studentquestionaire.entity;

import lombok.Value;

@Value
public class QuizReport {

    String name;
    String familyName;
    Integer questionCount;
    Integer successAnswersCount;
}
