package com.mb.software.ecampus.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class ExceptionHandlerAspect {

    private final HttpServletRequest httpServletRequest;

    public ExceptionHandlerAspect(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    @AfterThrowing(pointcut = "execution(* com.mb.software..*(..)))", throwing = "ex")
    public void exceptionHandler(JoinPoint joinPoint, Exception ex) {
        System.out.println("Hello");
       // log database
    }
}
