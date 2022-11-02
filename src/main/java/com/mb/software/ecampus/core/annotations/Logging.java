package com.mb.software.ecampus.core.annotations;

import com.mb.software.ecampus.core.crossCuttingConcerns.logging.BaseLoggingService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {
     Class<? extends BaseLoggingService> logType();
}
