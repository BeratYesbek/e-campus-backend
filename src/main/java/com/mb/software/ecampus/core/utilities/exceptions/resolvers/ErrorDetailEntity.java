package com.mb.software.ecampus.core.utilities.exceptions.resolvers;

import lombok.Builder;

import java.util.Date;

@Builder
public class ErrorDetailEntity {
    private String message;

    private String exceptionType;

    private String exceptionTrace;
    private Date date;

    private boolean success;

}
