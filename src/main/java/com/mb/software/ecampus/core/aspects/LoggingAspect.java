package com.mb.software.ecampus.core.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.BaseLoggingService;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.details.LogErrorDetail;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.FileLogging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.details.LogDetail;
import com.mb.software.ecampus.core.dataAccess.LoggingDao;
import com.mb.software.ecampus.core.utilities.constants.AnnotationPackageConstants;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * Logging Db or file aspect, it works only methods. Whenever method complete 'after method' will run.
 * Whenever system throw an exception 'afterThrowing method' will work for logging all errors to Db or File.
 * Aspect works with Logging Annotation
 * @see Logging
 * @see BaseLoggingService
 * @see DbLogging
 * @see FileLogging
 * @author Berat Yesbek (Feanor)
 */
@Aspect
@Configuration
public class LoggingAspect {

    private final LoggingDao loggingDao;
    private boolean isSuccess = true;

    public LoggingAspect(LoggingDao loggingDao) {
        this.loggingDao = loggingDao;
    }

    @After(AnnotationPackageConstants.LOGGING_ANNOTATION_PACKAGE)
    public void after(JoinPoint joinPoint) {
        if (!isSuccess) {
            return;
        }
        BaseLoggingService loggingService = getBaseLoggingServiceInstance(joinPoint);
        loggingService.info(setLogDetail(joinPoint));
    }
    /**
     * Handle all error for logging to Db or File
     */
    @AfterThrowing(pointcut = "execution(* *(..)) && @annotation(com.mb.software.ecampus.core.annotations.Logging)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        isSuccess = false;
        BaseLoggingService loggingService = getBaseLoggingServiceInstance(joinPoint);
        loggingService.error(setLogErrorDetail(joinPoint, exception));
    }


    private BaseLoggingService getBaseLoggingServiceInstance(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Logging logging = method.getAnnotation(Logging.class);
        BaseLoggingService loggingService;

        if (logging.logType() == DbLogging.class) {
            loggingService = new DbLogging(loggingDao);
        } else {
            loggingService = new FileLogging();
        }
        return loggingService;
    }

    @SneakyThrows
    private LogErrorDetail setLogErrorDetail(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getTarget().getClass().getName();
        methodName += "." + joinPoint.getSignature().getName();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String parameters = ow.writeValueAsString(joinPoint.getArgs());
        String message = exception.getMessage();
        String exceptionType = exception.getClass().getName();
        if (exception.getCause() != null) {
            message = exception.getCause().getMessage();
            exceptionType = exception.getCause().getClass().getName();

        }

        return new LogErrorDetail(message,
                parameters,
                methodName,
                joinPoint.getClass().getPackageName(),
                1,
                new Date(),
                Arrays.toString(exception.getStackTrace()), exceptionType);
    }

    @SneakyThrows
    private LogDetail setLogDetail(JoinPoint joinPoint) {
        String methodName = joinPoint.getTarget().getClass().getName();
        methodName += "." + joinPoint.getSignature().getName();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String parameters = ow.writeValueAsString(joinPoint.getArgs());

        return LogDetail.builder()
                .message("This method was run it at" + new Date().getTime() + "by " + "this user 1")
                .methodName(methodName)
                .packageName(joinPoint.getClass().getPackageName())
                .parameters(parameters)
                .userId(1)
                .createdAt(new Date()).build();
    }

}
