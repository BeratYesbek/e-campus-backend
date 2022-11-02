package com.mb.software.ecampus.core.handler;

import com.mb.software.ecampus.core.utilities.exceptions.resolvers.ErrorDetailEntity;
import com.mb.software.ecampus.core.utilities.exceptions.resolvers.ErrorType;
import com.mb.software.ecampus.core.utilities.exceptions.resolvers.ExceptionResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailEntity> handleExceptions(Exception exception, WebRequest webRequest) {
        ResponseEntity e = ExceptionResolver.exceptionResolve(exception);
        ErrorDetailEntity errorDetailEntity = (ErrorDetailEntity) e.getBody();
        return new ResponseEntity<>(
                ErrorDetailEntity.builder()
                        .message(errorDetailEntity.getMessage())
                        .exceptionType(errorDetailEntity.getExceptionType())
                        .date(errorDetailEntity.getDate())
                        .exceptionTrace(errorDetailEntity.getExceptionTrace())
                        .build(), e.getStatusCode());
    }
}
