package com.mb.software.ecampus.core.utilities.results;

public class ErrorResult extends Result {
    public ErrorResult(String message) {
        super(message, false);
    }

    public ErrorResult() {
        super(false);
    }
}
