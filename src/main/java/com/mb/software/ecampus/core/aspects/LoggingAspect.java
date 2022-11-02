package com.mb.software.ecampus.core.aspects;

import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.BaseLoggingService;
import com.mb.software.ecampus.core.utilities.constants.AnnotationPackageConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Configuration
public class LoggingAspect {

    @After(AnnotationPackageConstants.LOGGING_ANNOTATION_PACKAGE)
    public void after(JoinPoint joinPoint) throws InstantiationException, IllegalAccessException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Logging logging = method.getAnnotation(Logging.class);
        BaseLoggingService loggingService = logging.logType().newInstance();
        loggingService.info("This message will logged as info message");

    }

}
