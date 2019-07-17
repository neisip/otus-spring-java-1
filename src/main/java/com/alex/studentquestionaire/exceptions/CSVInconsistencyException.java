package com.alex.studentquestionaire.exceptions;

import lombok.NonNull;

public class CSVInconsistencyException extends RuntimeException {
    public CSVInconsistencyException(@NonNull String msg) { super(msg);}
}
