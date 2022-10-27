package com.mb.software.ecampus.business.abstracts;

import com.mb.software.ecampus.core.security.jwt.token.Token;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.entities.dtos.UserLoginDto;

public interface AuthService {

    DataResult<Token> login(UserLoginDto userLoginDto);

    DataResult<Token> register(User user);
}
