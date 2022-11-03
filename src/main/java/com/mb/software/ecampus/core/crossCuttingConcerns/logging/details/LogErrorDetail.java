package com.mb.software.ecampus.core.crossCuttingConcerns.logging.details;

import lombok.Getter;

import java.util.Date;

@Getter
public class LogErrorDetail extends LogDetail {

    private String stackTree;
    private String errorType;
    public LogErrorDetail(String message, String parameters, String methodName, String packageName, int userId, Date createdAt, String stackTree, String errorType) {
        super(message, parameters, methodName, packageName, userId, createdAt);
        this.stackTree = stackTree;
        this.errorType = errorType;
    }
}
