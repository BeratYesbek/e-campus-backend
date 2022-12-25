package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AuthService;
import com.mb.software.ecampus.core.entities.User;

import com.mb.software.ecampus.core.security.jwt.token.Token;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.dtos.UserLoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    public ResponseEntity<DataResult<Token>> login(@RequestBody UserLoginDto loginDto) {
        DataResult<Token> result = authService.login(loginDto);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("register")
    public ResponseEntity<DataResult<Token>> register(@RequestBody User user) throws Exception {
        DataResult<Token> result = authService.register(user);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
