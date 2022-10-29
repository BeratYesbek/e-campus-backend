package com.mb.software.ecampus.core.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.security.jwt.token.Token;
import com.mb.software.ecampus.core.security.jwt.token.TokenConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtHelperImpl implements JwtHelper {

    private final Environment environment;

    @Autowired
    public JwtHelperImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Token createToken(User user, String[] roles, String url) {
        Algorithm algorithm = Algorithm.HMAC512(environment.getProperty(TokenConstants.securityKey));
        long date = System.currentTimeMillis() + 14 * 24 * 3600 * 1000;
        Date expiry = new Date(date);
        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expiry)
                .withIssuer(url)
                .withNotBefore(new Date(System.currentTimeMillis()))
                .withKeyId(UUID.randomUUID().toString())
                .withClaim("roles", Arrays.asList(roles))
                .sign(algorithm);
        return new Token(accessToken, expiry);
    }

    @Override
    public DecodedJWT decodeJwtAndClaims(String token) {
        Algorithm algorithm = Algorithm.HMAC512(environment.getProperty(TokenConstants.securityKey));
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }
}
