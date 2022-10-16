package com.mb.software.ecampus.core.utilities.data;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data, String message) {
        super(data, message, false);
    }

    public ErrorDataResult(T data) {
        super(data, false);
    }
}
