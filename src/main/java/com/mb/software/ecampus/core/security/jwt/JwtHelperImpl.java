package com.mb.software.ecampus.core.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mb.software.ecampus.core.security.jwt.token.Token;
import com.mb.software.ecampus.entities.concretes.User;

public class JwtHelperImpl  implements JwtHelper  {


    @Override
    public Token createToken(User user, String url) {
        return null;
    }

    @Override
    public DecodedJWT decodeJwtAndClaims(String token) {
        return null;
    }
}
