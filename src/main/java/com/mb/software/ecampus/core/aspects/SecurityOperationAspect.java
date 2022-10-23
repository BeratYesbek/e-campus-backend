package com.mb.software.ecampus.core.aspects;

import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.utilities.constants.AnnotationPackageConstants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class SecurityOperationAspect {

    private HttpServletRequest request;

    @Autowired
    public SecurityOperationAspect(HttpServletRequest request) {
        this.request = request;
    }

    @Before(AnnotationPackageConstants.SECURITY_ANNOTATION_PACKAGE)
    public void before(JoinPoint point) {
        System.out.println("Hello world");
    }
}
