package com.mb.software.ecampus.core.utilities.exceptions.resolvers;

import com.mb.software.ecampus.core.utilities.exceptions.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.naming.AuthenticationException;
import java.util.Date;

public class ExceptionResolver {

    public static ResponseEntity<ErrorDetailEntity> exceptionResolve(Exception e) {
        if (e.getClass().equals(AuthorizationException.class)) {
            return resolveAuthorizationException(e);
        } else if (e.getClass().equals(AuthenticationException.class)) {
            return resolveAuthenticationException(e);
        }

        Throwable throwable = e.getCause();
        return new ResponseEntity<>(ErrorDetailEntity
                .builder()
                .exceptionType(ErrorType.UNUSUAL.name())
                .message(throwable.getMessage())
                .date(new Date())
                .success(false).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private static ResponseEntity<ErrorDetailEntity> resolveAuthorizationException(Exception e) {
        Throwable throwable = e.getCause();
        return new ResponseEntity<>(ErrorDetailEntity
                .builder()
                .exceptionType(ErrorType.AUTHORIZATION.name())
                .message(throwable.getMessage())
                .date(new Date())
                .success(false).build(), HttpStatus.UNAUTHORIZED);
    }

    private static ResponseEntity<ErrorDetailEntity> resolveAuthenticationException(Exception e) {
        Throwable throwable = e.getCause();
        return new ResponseEntity<>(ErrorDetailEntity
                .builder()
                .exceptionType(ErrorType.AUTHENTICATION.name())
                .message(throwable.getMessage())
                .date(new Date())
                .success(false).build(), HttpStatus.UNAUTHORIZED);
    }
}
