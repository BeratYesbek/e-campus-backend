package com.mb.software.ecampus.core.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.BaseLoggingService;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.FileLogging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.details.LogDetail;
import com.mb.software.ecampus.core.dataAccess.LoggingDao;
import com.mb.software.ecampus.core.utilities.constants.AnnotationPackageConstants;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Configuration
public class LoggingAspect {

    private final LoggingDao loggingDao;

    public LoggingAspect(LoggingDao loggingDao) {
        this.loggingDao = loggingDao;
    }

    @After(AnnotationPackageConstants.LOGGING_ANNOTATION_PACKAGE)
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Logging logging = method.getAnnotation(Logging.class);
        BaseLoggingService loggingService = null;

        if (logging.logType() == DbLogging.class) {
            loggingService = new DbLogging(loggingDao);
        } else {
            loggingService = new FileLogging();
        }

        loggingService.info(setLogDetail(joinPoint));

    }

    @SneakyThrows
    private final LogDetail setLogDetail(JoinPoint joinPoint) {
        String methodName = joinPoint.getTarget().getClass().getName();
        methodName += "." + joinPoint.getSignature().getName();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String parameters = ow.writeValueAsString(joinPoint.getArgs());

        return LogDetail.builder().message("This method was run it at" + new Date().getTime() + "by " + "this user 1")
                .methodName(joinPoint.getSignature().getName())
                .packageName(joinPoint.getClass().getPackageName())
                .parameters(parameters)
                .userId(1)
                .createdAt(new Date()).build();

    }

}
