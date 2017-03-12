package com.mcl.exceptions;

import java.lang.Exception;

public class FailureException extends Exception {
    private String message;

    public FailureException(String reason) {
        this.message = reason;
    }

    public String getMessage() {
        return this.message;
    }
}
