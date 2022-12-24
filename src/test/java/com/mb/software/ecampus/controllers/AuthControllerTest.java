package com.mb.software.ecampus.controllers;
import static org.mockito.Mockito.*;

import com.mb.software.ecampus.api.controllers.AuthController;
import com.mb.software.ecampus.core.business.abstracts.AuthService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.security.jwt.token.Token;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

@ExtendWith(SpringExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;
    @Test
    public void testLoginMethodIsWorkingProperly(){
        when(authService.login(any())).thenReturn(prepareLoginResponse());
        ResponseEntity<DataResult<Token>> response = authController.login(any());
        DataResult<Token> data = prepareLoginResponse();
        assertEquals(data.getData(),response.getBody().getData());
    }
    @Test
    public void testRegisterMethodIsWorkingProperly() throws Exception {
        when(authService.register(any())).thenReturn(prepareRegisterResponse());
        ResponseEntity<DataResult<Token>> response = authController.register(any());
        DataResult<Token> data = prepareRegisterResponse();
        assertEquals(data.getData(),response.getBody().getData());
    }
    private DataResult<Token> prepareLoginResponse(){
        return new SuccessDataResult<>(token);
    }

    private DataResult<Token> prepareRegisterResponse(){
        token.setUser(user);
        return new SuccessDataResult<>(token);
    }

    private static final User user = new User();
    private static final Token token = new Token("ahjhsja78qkwjeıqw",new Date());
}
