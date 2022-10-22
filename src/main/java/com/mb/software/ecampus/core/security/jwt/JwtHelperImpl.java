package com.mb.software.ecampus.core.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mb.software.ecampus.core.security.jwt.token.Token;
import com.mb.software.ecampus.core.security.jwt.token.TokenConstants;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

public class JwtHelperImpl implements JwtHelper {

    private final Environment environment;

    @Autowired
    public JwtHelperImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Token createToken(User user, String url) {
        Algorithm algorithm = Algorithm.HMAC512(environment.getProperty(TokenConstants.securityKey));
        Date expiry = new Date(System.currentTimeMillis());
        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(expiry)
                .withIssuer(url)
                .withNotBefore(new Date(System.currentTimeMillis()))
                .withKeyId(UUID.randomUUID().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
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
