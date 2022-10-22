package com.mb.software.ecampus.core.security.jwt.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class TokenOptions {

    @Autowired
    private Environment environment;

    private String securityKey;

    public String getSecurityKey() {
        this.securityKey = environment.getProperty("jwt.securityKey");
        return securityKey;
    }

}
