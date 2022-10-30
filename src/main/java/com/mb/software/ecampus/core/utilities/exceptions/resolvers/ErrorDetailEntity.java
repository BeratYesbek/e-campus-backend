package com.mb.software.ecampus.core.utilities.exceptions.resolvers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
public class ErrorDetailEntity {
    private String message;

    private String exceptionType;

    private String exceptionTrace;
    private Date date;

    private boolean success;

}
