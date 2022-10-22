package com.mb.software.ecampus.core.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mb.software.ecampus.core.security.jwt.token.Token;
import org.springframework.security.core.userdetails.User;

public interface JwtHelper {
    Token createToken(User user, String url);

    DecodedJWT decodeJwtAndClaims(String token);
}
