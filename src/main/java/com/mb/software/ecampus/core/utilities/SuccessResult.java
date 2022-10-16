package com.mb.software.ecampus.core.utilities;

public class SuccessResult extends Result {
    public SuccessResult(String message, boolean success) {
        super(message, success);
    }

    public SuccessResult(boolean success) {
        super(success);
    }
}
