package com.mb.software.ecampus.core.security.jwt.token;

import lombok.Builder;

import java.util.Date;

@Builder
public class Token {

    private String accessToken;

    private Date expiry;

}
