package com.mb.software.ecampus.core.aspects;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.security.jwt.JwtHelper;
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

    private final HttpServletRequest request;
    private final JwtHelper jwtHelper;
    @Autowired
    public SecurityOperationAspect(HttpServletRequest request, JwtHelper jwtHelper) {
        this.request = request;
        this.jwtHelper = jwtHelper;
    }

    @Before(AnnotationPackageConstants.SECURITY_ANNOTATION_PACKAGE)
    public void before(JoinPoint point) {
        String token = request.getHeader("Token");

        DecodedJWT decodedJWT = jwtHelper.decodeJwtAndClaims(token);

        String email = decodedJWT.getSubject();
        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);


    }
}
