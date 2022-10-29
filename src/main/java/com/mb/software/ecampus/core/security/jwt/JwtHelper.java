package com.mb.software.ecampus.core.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.security.jwt.token.Token;

public interface JwtHelper {
    Token createToken(User user, String[] roles, String url);

    DecodedJWT decodeJwtAndClaims(String token);
}
