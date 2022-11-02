package com.mb.software.ecampus.core.crossCuttingConcerns.logging;

import lombok.Builder;

import java.util.Date;

@Builder
public class LogDetail {

    private String message;
    private String parameters;
    private String methodName;
    private String packageName;
    private int userId;
    private Date createdAt;
}
