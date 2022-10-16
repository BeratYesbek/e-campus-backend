package com.mb.software.ecampus.core.utilities;

public class ErrorResult extends Result {
    public ErrorResult(String message, boolean success) {
        super(message, success);
    }

    public ErrorResult(boolean success) {
        super(success);
    }
}
