package com.mb.software.ecampus.core.utilities.data;

public class SuccessDataResult<T> extends DataResult<T> {
    public SuccessDataResult(T data, String message, boolean success) {
        super(data, message, success);
    }

    public SuccessDataResult(T data, boolean success) {
        super(data, success);
    }
}
