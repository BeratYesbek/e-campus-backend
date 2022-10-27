package com.mb.software.ecampus.core.security.jwt.token;

import com.mb.software.ecampus.core.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Token {

    private String accessToken;

    private Date expiry;

    private User user;


    public Token(String accessToken, Date expiry) {
        this.accessToken = accessToken;
        this.expiry = expiry;
    }
}
