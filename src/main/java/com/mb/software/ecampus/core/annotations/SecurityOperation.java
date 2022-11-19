package com.mb.software.ecampus.core.annotations;
import com.mb.software.ecampus.core.aspects.SecurityOperationAspect;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Security operation annotation that includes roles. It works with SecurityOperationAspect
 * @see SecurityOperationAspect
 * @author Berat Yesbek (Feanor)
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityOperation {
    String[] security();
}
