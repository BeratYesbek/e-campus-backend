package com.mb.software.ecampus.core.annotations;

import com.mb.software.ecampus.core.crossCuttingConcerns.logging.BaseLoggingService;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.FileLogging;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.aspects.LoggingAspect;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Logging Annotation that logging to Db or File. It works with aspect LoggingAspect;
 * @see LoggingAspect
 * @see BaseLoggingService
 * @see FileLogging
 * @see DbLogging
 * @author Berat Yesbek (Feanor)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {
     Class<? extends BaseLoggingService> logType();
}
