package com.mb.software.ecampus.core.utilities.data;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data, String message, boolean success) {
        super(data, message, success);
    }

    public ErrorDataResult(T data, boolean success) {
        super(data, success);
    }
}
