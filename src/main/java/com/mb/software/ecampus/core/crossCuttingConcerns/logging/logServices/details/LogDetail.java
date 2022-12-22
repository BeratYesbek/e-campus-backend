package com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.details;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class LogDetail {

    private String message;

    private String parameters;

    private String methodName;

    private String packageName;

    private int userId;

    private Date createdAt;
}
