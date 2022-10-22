package com.mb.software.ecampus.core.security.jwt.token;

import java.util.Date;


public class Token {

    private String accessToken;

    private Date expiry;


    public Token(String accessToken, Date expiry) {
        this.accessToken = accessToken;
        this.expiry = expiry;
    }
}
